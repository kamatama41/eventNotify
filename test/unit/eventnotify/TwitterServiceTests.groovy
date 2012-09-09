package eventnotify



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TwitterService)
class TwitterServiceTests {

    @Test
    void test_init_設定ファイルから値が読み込めているか() {
        def twitterService = new TwitterService()
        assert twitterService.consumerKey
        assert twitterService.consumerSecret
    }
}
