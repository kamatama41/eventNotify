package eventnotify

/**
 * イベントお気に入り機能のアクションを定義する
 * @author kamatama41
 *
 */
class BookmarkController {
    
    def atndService
    
    def index() {
       redirect(action:"search",params:params)
    }

    def search() {
        def searchParams = [:]
        searchParams.start = params.start ? new Integer(params.start) : 1
        searchParams.keyword = params.keyword ?: ''
        searchParams.onlyFewDays = (params.onlyFewDays == 'true' || params.onlyFewDays == 'on')
        def result = atndService.search(searchParams)
        result.searchParams = searchParams
        [searchResult: result]
    }

    def next() {
        params.start = new Integer(params.start)+10
        redirect(action:"search",params:params)
    }

    def prev() {
        params.start = new Integer(params.start)-10
        redirect(action:"search",params:params)
    }

    def show() {
        def event = atndService.get(params.eventId)
        [event: event]
    }
}
