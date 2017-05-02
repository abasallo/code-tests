package es.basallo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MainController)
class MainControllerSpec extends Specification {

    def 'gets a list with most common words for all posts as JSON and front ready'() {

        given:
        def expectedResult = '["Technology=9","REITs=9"]'

        when:
        controller.getAllPostingsMostCommonWords()

        then:
        response.text == expectedResult
    }

    def 'gets a list with most common words for each post as JSON and front ready'() {

        given:
        def expectedResult = '[[1,"[stocks:8]"],[2,"[managers:6, fund:6]"],[3,"[quarter:6]"],[4,"[Technology:9]"],[5,"[Covestor:5]"],[6,"[Covestor:5]"],[7,"[Covestor:6]"],[8,"[stocks:8]"],[9,"[REITs:9]"],[10,"[investment:5, Covestor:5]"]]'

        when:
        controller.getEachPostingMostCommonWords()

        then:
        response.text == expectedResult
    }
}
