package eventnotify

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.conf.ConfigurationContext;

/**
 * TwitterAPIを扱う
 * @author kamatama41
 *
 */
class TwitterService {
    final String consumerKey
    final String consumerSecret

    TwitterService () {
        def config = new TwitterConfig()
        consumerKey = config.consumerKey
        consumerSecret = config.consumerSecret
    }

    def getRequestToken(callbackUrl) {
        Twitter twitter = getTwitter()
        // Twitterからの戻り先を指定
        return twitter.getOAuthRequestToken(callbackUrl)
    }

    def getAccessToken(requestToken, oauthVerifier) {
        RequestToken myRequestToken = (RequestToken)requestToken
        Twitter twitter = getTwitter()

        return twitter.getOAuthAccessToken(myRequestToken, oauthVerifier)
    }

    def getTwitter() {
        Twitter twitter = new TwitterFactory().getInstance()
        twitter.setOAuthConsumer(consumerKey, consumerSecret)
        return twitter
    }
}
