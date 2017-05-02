package es.basallo

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import spock.lang.Specification

@TestFor(User)
@TestMixin(DomainClassUnitTestMixin)
class UserSpec extends Specification {

    def setupSpec() {
        mockDomain User
        mockDomain Report
    }

    def 'all fields are mandatory'() {

        given:
        def userNullName = new User(name: null, locale: new Locale('en', 'GB'))
        def userNullLocale = new User(name: 'name', locale: null)
        def userComplete = new User(name: 'name', locale: new Locale('en', 'GB'))

        when:
        userNullName.save()
        userNullLocale.save()
        userComplete.save()

        then:
        !userNullName.validate()
        !userNullLocale.validate()
        userComplete.validate()
    }

    def 'name cannot be blank'() {

        given:
        def userBlankName = new User(name: '', locale: new Locale('en', 'GB'))

        when:
        userBlankName.save()

        then:
        !userBlankName.validate()
    }


    def "adds a user to user's list"() {
        given:
        def userComplete = new User(name: 'name', locale: new Locale('en', 'GB')).save()
        def reportComplete = new Report(name: 'name', user: new User(name: 'name', locale: new Locale('en', 'GB')).save()).save()

        when:
        userComplete.addReport reportComplete

        then:
        userComplete.reports.first() == reportComplete
    }

    def "checks if a user is french"() {

        setup:
        def userBritish = new User(name: 'name', locale: new Locale('en', 'GB')).save()
        def userFrench = new User(name: 'name', locale: new Locale('fr', 'FR')).save()

        expect:
        !userBritish.isFrench()
        userFrench.isFrench()
    }
}


