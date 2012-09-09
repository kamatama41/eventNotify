package eventnotify

/**
 * ATNDの検索結果を保持します。
 * @author kamatama41
 *
 */
class AtndEventSearchResult {
    def searchParams = [:]
    int available = 0;
    int returned = 0;
    List<Event> events = []
    def getStart() {
        searchParams.start ?: 0
    }
    def getEnd() {
        getStart() + events.size() - 1
    }
    def getKeyword() {
        searchParams.keyword ?: ""
    }
    def getOnlyFewDays() {
        searchParams.onlyFewDays ?: false
    }
    def getPrevable() {
        getStart() > 1
    }
    def getNextable() {
        getEnd() < available
    }
}
