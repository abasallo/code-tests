package es.basallo

import spock.lang.Specification
import spock.lang.Unroll

class StringUtilsSpec extends Specification {

    @Unroll
    def 'Encodes using ROT13'() {

        expect:
        StringUtils.toROT13(textToEncode) == encodedText

        where:
        textToEncode    | encodedText
        null            | ''
        ''              | ''
        'ñ'             | 'ñ'
        'Ñ'             | 'Ñ'
        'abcdefghijklm' | 'nopqrstuvwxyz'
        'ABCDEFGHIJKLM' | 'NOPQRSTUVWXYZ'
        'nopqrstuvwxyz' | 'abcdefghijklm'
        'NOPQRSTUVWXYZ' | 'ABCDEFGHIJKLM'
    }
}


