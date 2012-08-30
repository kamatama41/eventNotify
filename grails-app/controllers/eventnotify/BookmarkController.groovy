package eventnotify

class BookmarkController {
    
    def atndService
    
    def index() {
       redirect(action:"search",params:params)
    }

    def search() {
        def searchParams = [:]
        searchParams.start = params.start ? new Integer(params.start) : 1
        searchParams.keyword = params.keyword
        def result = atndService.search(searchParams)
        result.searchParams = searchParams
        [searchResult: result]
    }

    def next() {
        params.start = params.start ? new Integer(params.start)+10 : 1
        redirect(action:"search",params:params)
    }

    def prev() {
        params.start = (params.start && new Integer(params.start) > 10) ? new Integer(params.start)-10 : 1
        redirect(action:"search",params:params)
    }

    def show() {
        def event = atndService.get(params.eventId)
        [event: event]
    }
}
