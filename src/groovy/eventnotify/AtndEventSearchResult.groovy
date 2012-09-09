package eventnotify

class AtndEventSearchResult {
    def searchParams = [:]
    int available;
    int returned;
    List<Event> events = []
    def getStart() {
        searchParams.start
    }
    def getEnd() {
        getStart() + events.size() - 1
    }
    def getKeyword() {
        searchParams.keyword
    }
    def getOnlyFewDays() {
        searchParams.onlyFewDays
    }
    def getPrevable() {
        getStart() > 1
    }
    def getNextable() {
        getEnd() < available
    }
}
