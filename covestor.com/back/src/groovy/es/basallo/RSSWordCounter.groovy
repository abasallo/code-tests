package es.basallo

class RSSWordCounter {

    final static String RSS_FEED_URL = 'http://blog.covestor.com/feed'
    final static String EXCLUDED_WORDS_LIST_RSS = 'http://www.textfixer.com/resources/common-english-words.txt'

    static getAllPostingsMostCommonWords() {

        def allPostingsMostCommonWords = [:]
        getEachPostingMostCommonWords().each { postingsMostCommonWords ->
            if (allPostingsMostCommonWords) {
                if (allPostingsMostCommonWords.entrySet().first().value < postingsMostCommonWords.entrySet().first().value) {
                    allPostingsMostCommonWords = postingsMostCommonWords
                } else if (allPostingsMostCommonWords.entrySet().first().value == postingsMostCommonWords.entrySet().first().value) {
                    allPostingsMostCommonWords << postingsMostCommonWords
                }
            } else {
                allPostingsMostCommonWords = postingsMostCommonWords
            }
        }

        allPostingsMostCommonWords
    }

    static getEachPostingMostCommonWords() {

        def counts = getPostContentListFrom(RSS_FEED_URL).collect { content ->
            def filteredTokenizedWords = filterNonWordCharacters(content.text()).tokenize()
            def wordsCommonEnglishWordsFilteredSet = filterCommonEnglishWords(filteredTokenizedWords.toSet())
            calculateEachWordAppearances(filteredTokenizedWords, wordsCommonEnglishWordsFilteredSet)
        }

        def maxAppearances = counts.collect { count ->
            calculateMaxAppearancesFrom count
        }

        maxAppearances
    }

    private static getPostContentListFrom(fileName) {
        def rss = new XmlParser().parse(fileName)
        rss.channel.item.'content:encoded'
    }

    private static calculateEachWordAppearances(words, wordsCommonEnglishWordsFilteredSet) {

        def count = [:]
        wordsCommonEnglishWordsFilteredSet.each { filteredWord ->
            def ocurrences = words.findAll {
                it == filteredWord
            }.size()
            count << ["${filteredWord}": ocurrences]
        }

        count
    }

    private static String filterNonWordCharacters(String text) {
        def textNonBreakingSpacesFiltered = filterNonBreakingSpaces text
        def htmlFilteredText = filterHTMLTags textNonBreakingSpacesFiltered
        filterPunctuation htmlFilteredText
    }

    private static String filterNonBreakingSpaces(String text) {
        text.replace('&nbsp;', ' ')
    }

    private static String filterHTMLTags(String text) {

        def htmlFilteredText = text
        text.findAll(/<(.|\n)*?>/).each {
            htmlFilteredText -= it
        }

        htmlFilteredText
    }

    private static String filterPunctuation(String text) {

        def punctuationFilteredText = text
        text.findAll(/[.,!?()]/).each {
            punctuationFilteredText -= it
        }

        punctuationFilteredText
    }

    private static calculateMaxAppearancesFrom(count) {

        def maxAppearances = 1
        def result = [:]
        count.each { wordCount ->
            if (wordCount.value >= maxAppearances) {
                if (wordCount.value > maxAppearances) {
                    result = [:]
                    maxAppearances++
                }
                result << wordCount
            }
        }

        result
    }

    private static Set getCommonEnglishWordSetFrom(fileName) {
        String fileContent = fileName.toURL().text
        fileContent.tokenize(',').toSet()
    }

    private static Set filterCommonEnglishWords(wordsSet) {

        def commonEnglishWordSet = getCommonEnglishWordSetFrom(EXCLUDED_WORDS_LIST_RSS)
        def filterCommonEnglishWordsSet = []
        wordsSet.each { word ->
            def remove = false
            for (commonWord in commonEnglishWordSet) {
                if (word.toLowerCase() == commonWord.toLowerCase())
                    remove = true
            }
            if (!remove)
                filterCommonEnglishWordsSet << word
        }

        filterCommonEnglishWordsSet
    }
}
