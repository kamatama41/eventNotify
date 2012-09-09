package eventnotify



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AtndService)
class AtndServiceTests {

    void testSearch_キーワードがない場合は結果が0件() {
        def atndService = new AtndService()
        
        def result = atndService.search([:])
        assert result == [:]
    }

    void testSearch_キーワードのみで検索() {
        def atndService = new AtndService()
        
        def result = atndService.search(['keyword': 'TDD'])
        println result.returned
        println result.available
        assert result.events.size() != 0
        result.events.each { event ->
            println event.eventId
            println event.name
            println event.startedAt
            println event.capacity
            println event.place
            println event.url
            println ''
            assert event.eventId != 0
        }
    }

    void testSearch_未来のイベントのみ検索() {
        def atndService = new AtndService()
        def result = atndService.search(['keyword': 'java', 'onlyFewDays':true])
        println result.returned
        println result.available
        assert result.events.size() != 0
        result.events.each { event ->
            println event.eventId
            println event.name
            println event.startedAt
            println event.capacity
            println event.place
            println event.url
            println ''
            assert event.eventId != 0
            assert event.startedAt.format('yyyyMM') >= new Date().format('yyyyMM')
        }
    }

    void testGet() {
        def atndService = new AtndService()
        def event = atndService.get(30622)
        println event.eventId
        println event.name
        println event.startedAt
        println event.capacity
        println event.place
        println event.url
        println ''
        assert event.eventId != 0
    }
}
