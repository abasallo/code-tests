package es.basallo

class UserController {

    def reportService

    def index() {
        [users: User.list().sort { it.id }]
    }

    def show() {
        [user: User.get(params.id)]
    }

    def addReport() {
        def user = User.get(params.id)
        user.addReport reportService.createReport(params.id)
        redirect action: 'show', id: params.id
    }
}



