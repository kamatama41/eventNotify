package eventnotify

@Grab(group='rome', module='rome', version='1.0')
import com.sun.syndication.io.impl.DateParser

class AtendService {

    def search(params) {
        def addr = "http://api.atnd.org/events?keyword=${params.keyword}&format=xml"
        def text = new URL(addr).text
        def xml = new XmlParser().parseText(text)
        def result = []
        xml.events.event.each { eventNode ->
            def event = new Event()
            event.name = eventNode.title.text()
            event.date = DateParser.parseW3CDateTime(eventNode.updated_at.text())
            event.place = eventNode.address.text()
            event.capacity = new Integer(eventNode.accepted.text())
            result << event
        }
        return result
    }
}
