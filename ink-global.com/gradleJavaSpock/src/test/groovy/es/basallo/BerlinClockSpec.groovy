package es.basallo

import spock.lang.Specification
import spock.lang.Unroll

class BerlinClockSpec extends Specification {

    @Unroll
    def 'First line - the light blinks yellow every two seconds'() {

        expect:
        new BerlinClock(hours, minutes, seconds).twoSecondsLine() == lineText

        where:
        hours | minutes | seconds | lineText
        0     | 0       | 0       | 'Y'
        13    | 17      | 1       | 'O'
        23    | 59      | 59      | 'O'
        24    | 0       | 0       | 'Y'
    }

    @Unroll
    def 'Second line - every red light represents five hours'() {

        expect:
        new BerlinClock(hours, minutes, seconds).fiveHoursLine() == lineText

        where:
        hours | minutes | seconds | lineText
        0     | 0       | 0       | 'OOOO'
        13    | 17      | 1       | 'RROO'
        23    | 59      | 59      | 'RRRR'
        24    | 0       | 0       | 'RRRR'
    }

    @Unroll
    def 'Third line - every red light is an hour'() {

        expect:
        new BerlinClock(hours, minutes, seconds).oneHourLine() == lineText

        where:
        hours | minutes | seconds | lineText
        0     | 0       | 0       | 'OOOO'
        13    | 17      | 1       | 'RRRO'
        23    | 59      | 59      | 'RRRO'
        24    | 0       | 0       | 'RRRR'
    }

    @Unroll
    def 'Fourth line - every yellow light represents five minutes (those corresponding to quarters are red)'() {

        expect:
        new BerlinClock(hours, minutes, seconds).fiveMinutesLine() == lineText

        where:
        hours | minutes | seconds | lineText
        0     | 0       | 0       | 'OOOOOOOOOOO'
        13    | 17      | 1       | 'YYROOOOOOOO'
        23    | 59      | 59      | 'YYRYYRYYRYY'
        24    | 0       | 0       | 'OOOOOOOOOOO'
    }

    @Unroll
    def 'Fifth line - every yellow light is a minute'() {

        expect:
        new BerlinClock(hours, minutes, seconds).oneMinuteLine() == lineText

        where:
        hours | minutes | seconds | lineText
        0     | 0       | 0       | 'OOOO'
        13    | 17      | 1       | 'YYOO'
        23    | 59      | 59      | 'YYYY'
        24    | 0       | 0       | 'OOOO'
    }
}

