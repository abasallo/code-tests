package es.basallo

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import spock.lang.Specification

@TestFor(Report)
@TestMixin(DomainClassUnitTestMixin)
class ReportSpec extends Specification {

    def setupSpec() {
        mockDomain User
        mockDomain Report
    }

    def 'all fields are mandatory'() {

        given:
        def reportNullName = new Report(name: null, user: new User(name: 'name', locale: new Locale('en', 'GB')).save())
        def reportNullParentUser = new Report(name: 'name', user: null)
        def reportComplete = new Report(name: 'name', user: new User(name: 'name', locale: new Locale('en', 'GB')).save())

        when:
        reportNullName.save()
        reportNullParentUser.save()
        reportComplete.save()

        then:
        !reportNullName.validate()
        !reportNullParentUser.validate()
        reportComplete.validate()
    }

    def 'name cannot be blank'() {

        given:
        def reportBlankName = new Report(name: '', user: new User(name: 'name', locale: new Locale('en', 'GB')).save())

        when:
        reportBlankName.save()

        then:
        !reportBlankName.validate()
    }
}


