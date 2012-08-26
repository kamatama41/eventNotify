package eventnotify

class User {
    String userId
    String userName
    static hasMany = [keywords: Keyword]
    static constraints = {
        userId unique: true
    }
    String toString() { userId }
}
