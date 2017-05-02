package es.basallo

import spock.lang.Specification

class RSSWordCounterSpec extends Specification {

    def 'gets a list with most common words for all posts'() {

        setup:
        def expectedResult = '[Technology:9, REITs:9]'

        expect:
        RSSWordCounter.getAllPostingsMostCommonWords().toString() == expectedResult
    }

    def 'gets a list with most common words for each post'() {

        setup:
        def expectedResult = '[[stocks:8], [managers:6, fund:6], [quarter:6], [Technology:9], [Covestor:5], [Covestor:5], [Covestor:6], [stocks:8], [REITs:9], [investment:5, Covestor:5]]'

        expect:
        RSSWordCounter.getEachPostingMostCommonWords().toString() == expectedResult
    }
}

