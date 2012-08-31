package eventnotify

import com.sun.syndication.io.impl.DateParser

class AtndService {
    static final String BASE_URL = 'http://api.atnd.org/'
    
    def search(params) {
        if(!params.keyword) return [:]
        def keyword = params.keyword.replaceAll(' ', ',')
        def addr = "${BASE_URL}events?keyword=${keyword}&start=${params.start}&format=xml"
        def xml = new XmlParser().parseText(new URL(addr).text)
        return perse(xml)
    }

    def get(eventId) {
        def addr = "${BASE_URL}events?event_id=${eventId}&format=xml"
        def text = new URL(addr).text
        def xml = new XmlParser().parseText(text)
        return perse(xml).events[0] 
    }

    private def perse(xml) {
        def result = [:]
        def events = []
        xml.events.event.each { eventNode ->
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
        result['events'] = events.sort{ it.startedAt }
        result['returned'] = new Integer(xml.results_returned.text())
        result['available'] = new Integer(xml.results_available.text())
        
        return result
    }
}
