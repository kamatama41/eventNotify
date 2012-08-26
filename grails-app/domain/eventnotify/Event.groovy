package eventnotify

import java.util.Date;

class Event {
    String name
    Date date
    String place
    int capacity

    static constraints = {
        name(blank:false)
        date()
        place(blank:false)
        capacity(min:0)
    }
}
