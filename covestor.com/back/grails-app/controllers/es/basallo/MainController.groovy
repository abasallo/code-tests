package es.basallo

import grails.converters.JSON

class MainController {

    def beforeInterceptor = {
        header 'Access-Control-Allow-Origin', '*'
        header 'Access-Control-Allow-Methods', 'GET'
    }

    def getAllPostingsMostCommonWords() {
        def allPostingsMostCommonWords = RSSWordCounter.getAllPostingsMostCommonWords()
        def allPostingsMostCommonWordsToString = []
        allPostingsMostCommonWords.each {
            allPostingsMostCommonWordsToString << it.toString()
        }
        render allPostingsMostCommonWordsToString as JSON

    }

    def getEachPostingMostCommonWords() {
        def eachPostingMostCommonWords = RSSWordCounter.getEachPostingMostCommonWords()
        def eachPostingMostCommonWordsToString = []
        eachPostingMostCommonWords.eachWithIndex { it, index ->
            eachPostingMostCommonWordsToString << [index + 1, it.toString()]
        }
        render eachPostingMostCommonWordsToString as JSON
    }
}