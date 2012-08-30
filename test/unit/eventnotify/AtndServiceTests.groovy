package eventnotify



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AtndService)
class AtndServiceTests {

    void testSearch() {
        def atndService = new AtndService()
        def result = atndService.search(['keyword': 'TDD'])
        println result.returned
        println result.available
        assert result.events.size() != 0
        result.events.each { event ->
            println event.eventId
            println event.name
            println event.date
            println event.capacity
            println event.place
            println event.url
            println ''
            assert event.eventId != 0
        }
        
    }
    
    void testGet() {
        def atndService = new AtndService()
        def event = atndService.get(30622)
        println event.eventId
        println event.name
        println event.date
        println event.capacity
        println event.place
        println event.url
        println ''
        assert event.eventId != 0
    }
}
