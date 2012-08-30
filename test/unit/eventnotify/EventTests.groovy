package eventnotify



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Event)
class EventTests {
    Event target

    @Before
    void setUp() {
        target = new Event(eventId:1, name:"test", date:new Date(1), place:"test", capacity:1, url:'http://hogehoge.com')
    }

    void testValidation_不正なイベントID() {
        target.eventId = 0
        assert !target.validate()
    }
    void testValidation_不正なイベント名() {
        target.name = null
        assert !target.validate()
    }
    void testValidation_イベント場所はなくてもOK() {
        target.place = null
        assert target.validate()
    }
    void testValidation_イベント人数が負の数の場合() {
        target.capacity = -1
        assert !target.validate()
    }
    void testValidation_イベント人数が0人はOK() {
        target.capacity = 0
        assert target.validate()
        
        target.url = null
        assert !target.validate()
    }
    void testValidation_URLとして不適切() {
        target.url = "abcdefg"
        assert !target.validate()
    }

    void testPersistence() {
        assert Event.count == 0
        
        target.save()
        assert Event.count == 1
        
        def result = Event.list().get(0)
        assert result == target
    }
}
