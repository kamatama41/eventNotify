import eventnotify.User

class BootStrap {

    def init = { servletContext ->
        def kamatama41 = new User(userId: "kamatama41", userName: "shinichi")
        kamatama41.save(failOnError: true) 
    }
    def destroy = {
    }
}
