package eventnotify

/**
 * ユーザー情報を管理します。
 * @author kamatama41
 *
 */
class User implements Serializable {
    String name
    static constraints = {
        name(blank:true)
    }
}
