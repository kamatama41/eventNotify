package eventnotify

/**
 * アカウント管理のアクションを定義する
 * @author kamatama41
 *
 */
class AccountController {

    def twitterService

    def index() {
    }

    def twitter() {
        def uri =  request.requestURL   // http://${HOST}/grails/account/twitter.dispatch
        def callbackUrl = "${uri.replaceAll('/grails', '').replaceAll('.dispatch', '').replaceAll('twitter', 'accessToken')}"
        def requestToken = twitterService.getRequestToken(callbackUrl)
        session.requestToken = requestToken
        redirect(url:requestToken.getAuthorizationURL())
    }

    def accessToken() {
        def requestToken = session.requestToken
        def accessToken = twitterService.getAccessToken(requestToken, params.oauth_verifier)
        session.user = new User(name:accessToken.screenName)
        session.requestToken = null
        redirect(action:'index')
    }

    def logout() {
        session.user = null
        // トップページへ帰る
        redirect(uri: "")
    }
}
