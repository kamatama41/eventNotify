package eventnotify



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AtendService)
class AtendServiceTests {
    @Test
    void testSearch() {
        def atendService = new AtendService()
        def events = atendService.search(['keyword': 'TDD'])
        events.each { event ->
            println event.name
            println event.date
            println event.capacity
            println event.place
            println ''
        }
    }
}
