package eventnotify

class BookmarkController {
    def index() { 
    }

    def search() {
        def events = atendApiService.search(params)
        [eventList: events]
    }

    def show() {
        def event = atendApiService.get(eventId)
        [event: event]
    }
}
