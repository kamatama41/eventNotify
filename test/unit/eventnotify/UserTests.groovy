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
        target = new User(userId:"test_id", userName:"test_name")
    }
    
    void test_validateion_userIdがnullのときエラーになる() {
        target.userId = null
        assert !target.validate()
    }
    
    void test_validation_userNameがnullのときエラーになる() {
        target.userName = null
        assert !target.validate()
    }
}
