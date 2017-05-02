package es.basallo

import spock.lang.Specification
import spock.lang.Unroll

class BerlinClockIntegrationSpec extends Specification {

    @Unroll
    def 'Full integration with given test data'() {

        setup:
        def berlinClock = new BerlinClock(TimeUtils.parsedMapFromInput(input))

        expect:
        berlinClock.toString() == result

        where:
        input      | result
        '00:00:00' | 'Y OOOO OOOO OOOOOOOOOOO OOOO'
        '13:17:01' | 'O RROO RRRO YYROOOOOOOO YYOO'
        '23:59:59' | 'O RRRR RRRO YYRYYRYYRYY YYYY'
        '24:00:00' | 'Y RRRR RRRR OOOOOOOOOOO OOOO'
    }
}

