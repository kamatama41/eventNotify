package eventnotify

class User {
    String userId
    String userName
    static constraints = {
        userId(blank:false)
        userName(blank:false)
    }
}
