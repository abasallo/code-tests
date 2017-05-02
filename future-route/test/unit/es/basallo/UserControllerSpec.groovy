package es.basallo

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.web.ControllerUnitTestMixin
import spock.lang.Specification

@TestFor(UserController)
@TestMixin([ControllerUnitTestMixin, DomainClassUnitTestMixin])
class UserControllerSpec extends Specification {

    def 'shows all users as index'() {

        given:
        mockDomain User
        def user = new User(name: 'user1', locale: new Locale('en', 'GB')).save()
        def userList = [user]

        when:
        def model = controller.index()

        then:
        model.users == userList
    }

    def 'show user for given id'() {

        given:
        mockDomain User
        def user = new User(name: 'user1', locale: new Locale('en', 'GB')).save()

        when:
        params.id = 1
        def model = controller.show()

        then:
        model.user == user
    }

    def 'adds report to user'() {

        given:
        mockDomain User
        mockDomain Report
        def user = new User(name: 'user1', locale: new Locale('en', 'GB')).save()
        def report = new Report(name: 'name', user: user)
        controller.reportService = Mock(ReportService)
        user.metaClass.addReport = { reportToAdd ->
            user.reports = [reportToAdd]
            user.save()
        }

        when:
        params.id = 1
        controller.addReport()

        then:
        1 * controller.reportService.createReport(1) >> report

        user.reports.first() == report
        response.redirectedUrl == '/user/show/1'
    }

}


