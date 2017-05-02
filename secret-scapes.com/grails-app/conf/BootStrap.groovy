import es.basallo.secretscapescodetest.Account

class BootStrap {

    def init = { servletContext ->

        new Account(name: 'Athos', email: 'athos@dumas.fr').save()
        new Account(name: 'Porthos', email: 'porthos@dumas.fr').save()
        new Account(name: 'Aramis', email: 'aramis@dumas.fr').save()
    }

    def destroy = {}
}
