package es.basallo

import spock.lang.Specification
import spock.lang.Unroll

class TimeUtilsSpec extends Specification {

    @Unroll
    def 'Parsed Map from input String'() {

        expect:
        TimeUtils.parsedMapFromInput(inputString) == map

        where:
        inputString | map
        '00:00:00'  | [hours: 0, minutes: 0, seconds: 0]
        '0:00:00'   | [hours: 0, minutes: 0, seconds: 0]
        '00:0:00'   | [hours: 0, minutes: 0, seconds: 0]
        '00:00:0'   | [hours: 0, minutes: 0, seconds: 0]
        '13:17:01'  | [hours: 13, minutes: 17, seconds: 1]
        '23:59:59'  | [hours: 23, minutes: 59, seconds: 59]
        '24:00:00'  | [hours: 24, minutes: 0, seconds: 0]
    }

    @Unroll
    def 'Unparseable values for input result in an Exception'() {

        when:
        TimeUtils.parsedMapFromInput(inputString)

        then:
        thrown exception

        where:
        inputString | exception
        null        | NullPointerException
        ''          | NumberFormatException
        '00:00:AA'  | NumberFormatException
        '00:AA:AA'  | NumberFormatException
        'AA:AA:AA'  | NumberFormatException
    }

    @Unroll
    def 'Number of minutes in a given time'() {

        expect:
        TimeUtils.toMinutes(hours, minutes) == numberOfMinutes

        where:
        hours | minutes | numberOfMinutes
        0     | 0       | 0
        13    | 17      | 797
        23    | 59      | 1439
        24    | 0       | 1440
    }

    @Unroll
    def 'Number of seconds in a given time'() {

        expect:
        TimeUtils.toSeconds(hours, minutes, seconds) == numberOfSeconds

        where:
        hours | minutes | seconds | numberOfSeconds
        0     | 0       | 0       | 0
        13    | 17      | 1       | 47821
        23    | 59      | 59      | 86399
        24    | 0       | 0       | 86400
    }

    @Unroll
    def 'Number of five hours groups in a given time'() {

        expect:
        TimeUtils.fiveHoursGroups(hours) == numberOfFiveHoursGroups

        where:
        hours | numberOfFiveHoursGroups
        0     | 0
        13    | 2
        23    | 4
        24    | 4
    }

    @Unroll
    def 'Number of one hour groups in a given time'() {

        expect:
        TimeUtils.oneHourGroups(hours) == numberOfOneHourGroups

        where:
        hours | numberOfOneHourGroups
        0     | 0
        13    | 3
        23    | 3
        24    | 4
    }

    @Unroll
    def 'Number of five minutes groups in a given time'() {

        expect:
        TimeUtils.fiveMinutesGroups(hours, minutes) == numberOfFiveMinutesGroups

        where:
        hours | minutes | numberOfFiveMinutesGroups
        0     | 0       | 0
        13    | 17      | 3
        23    | 59      | 11
        24    | 0       | 0
    }

    @Unroll
    def 'Number of one minute groups in a given time'() {

        expect:
        TimeUtils.oneMinuteGroups(hours, minutes) == numberOfOneMinuteGroups

        where:
        hours | minutes | numberOfOneMinuteGroups
        0     | 0       | 0
        13    | 17      | 2
        23    | 59      | 4
        24    | 0       | 0
    }
}

