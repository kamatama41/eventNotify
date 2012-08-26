package eventnotify



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Event)
class EventTests {
    void testValidation() {
        def event = new Event(name:"test", date:new Date(1), place:"test", capacity:1)
        
        event.name = null
        assert !event.validate()

        event.name = "test"
        event.place = null
        assert !event.validate()
        
        event.place = "test"
        event.capacity = -1
        assert !event.validate()
        
        event.capacity = 1
        assert event.validate()
    }

    void testPersistence() {
        assert Event.count == 0
        
        def event = new Event(name:"TestEvent", date:new Date(1), place:"TestPlace", capacity:12)
        event.save()
        assert Event.count == 1
        
        def result = Event.list().get(0)
        assert result == event
    }
}
