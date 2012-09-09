package eventnotify

import com.sun.syndication.io.impl.DateParser
import groovyx.net.http.URIBuilder

/**
 * ATNDのAPIを扱う
 * @author kamatama41
 *
 */
class AtndService {
    private static final String BASE_URL = 'http://api.atnd.org/'

    /**
     * イベント検索を実行します。
     * @param searchParams 検索パラメタのMap
     * @return {@link AtndEventSearchResult}オブジェクト
     */
    def search(searchParams) {
        if(!searchParams.keyword) return [:]
        def uri = new URIBuilder(BASE_URL).setPath('events').setQuery(createSearchParames(searchParams))
        def xml = new XmlParser().parseText(uri.toURL().text)
        return perse(xml)
    }

    /**
    * イベント検索を実行します。
    * @param eventId 対象のイベントID
    * @return {@link Event}オブジェクト
    */
    def get(eventId) {
        def uri = new URIBuilder(BASE_URL).setPath('events').setQuery([event_id: eventId])
        def xml = new XmlParser().parseText(uri.toURL().text)
        return perse(xml).events[0]
    }

    /**
     * URIBuilderに食わせる用のパラメタのMapを作成します。
     * @param searchParams searchメソッドの引数として来た、検索用パラメタのMap
     * @return
     */
    private def createSearchParames(searchParams) {
        def urlParams = [:]
        // keywordは半角スペースを区切とみなす
        urlParams.keyword = searchParams.keyword.split(' ').toList()

        // startは必須ではない
        if(searchParams.start) {
            urlParams.start = searchParams.start
        }

        // 直近3か月のみを対象とするか
        if(searchParams.onlyFewDays) {
            def ymd = ''
            def today = new Date()
            use(groovy.time.TimeCategory) {
                def dateFormat = 'yyyyMM'
                urlParams.ym = [(today).format(dateFormat), (today + 1.months).format(dateFormat),(today + 2.months).format(dateFormat)]
            }
        }

        // formatは固定
        urlParams.format = 'xml'

        return urlParams
    }

    /**
     * 検索メソッドの結果として来たxmlを結果オブジェクトにパースします。
     * @param xml 検索メソッドの結果
     * @return {@link AtndEventSearchResult}
     */
    private def perse(xml) {
        AtndEventSearchResult result = new AtndEventSearchResult()
        def events = []
        xml.events.event
        .each { eventNode ->
            def event = new Event()
            event.eventId = new Integer(eventNode.event_id.text() ?: 0)
            event.name = eventNode.title.text()
            event.startedAt = DateParser.parseW3CDateTime(eventNode.started_at.text())
            event.endedAt = DateParser.parseW3CDateTime(eventNode.ended_at.text())
            event.place = eventNode.place.text()
            event.address = eventNode.address.text()
            event.accepted = new Integer(eventNode.accepted.text() ?: 0)
            event.capacity = new Integer(eventNode.limit.text() ?: 0)
            event.url = eventNode.event_url.text()
            events << event
        }
        
        result.events = events
        result.returned = new Integer(xml.results_returned.text())
        result.available = new Integer(xml.results_available.text())
        
        return result
    }
}
