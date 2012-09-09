package eventnotify

import java.util.Date;

/**
 * イベント情報を管理します。
 * @author kamatama41
 *
 */
class Event {
    int eventId
    String name
    Date startedAt
    Date endedAt
    String place
    String address
    int accepted
    int capacity
    String url

    static constraints = {
        eventId(min:1)
        name(blank:false)
        startedAt()
        endedAt()
        place(nullable:true)
        accepted(min:0)
        capacity(min:0)
        url(url:true)
    }
}
