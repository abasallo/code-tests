import es.basallo.User

class BootStrap {

    def init = { servletContext ->

        environments {

            development {
                createDefaultUsers()
            }

            test {
                createDefaultUsers()
            }

            production {
                createDefaultUsers()
            }
        }
    }

    def destroy = {}

    private createDefaultUsers() {
        new User(name: 'James', locale: new Locale('en', 'GB')).save()
        new User(name: 'Marie', locale: new Locale('fr', 'FR')).save()
    }
}
