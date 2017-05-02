package es.basallo

class StringUtils {

    static String toROT13(String textToEncode) {

        def encodedText = ""
        textToEncode.collect {
            if (('a'..'m').contains(it) || ('A'..'M').contains(it))
                encodedText += ((it as Character) + 13) as Character
            else if (('n'..'z').contains(it) || ('N'..'Z').contains(it))
                encodedText += ((it as Character) - 13) as Character
            else
                encodedText += it
        }
        encodedText
    }
}