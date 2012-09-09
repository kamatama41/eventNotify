package eventnotify



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

    User target
    
    @Before
    void setUp() {
        target = new User(userName:"test_name")
    }
    
    void test_validation_userNameがnullのときエラーにならない() {
        target.userName = null
        assert target.validate()
    }
}
