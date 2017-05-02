package es.basallo

class BerlinClock {

    Integer hours
    Integer minutes
    Integer seconds

    final HOURS_LINE_CONFIGURATION = ['OOOO', 'ROOO', 'RROO', 'RRRO', 'RRRR']
    final FIVE_MINUTES_LINE_CONFIGURATION = ['OOOOOOOOOOO', 'YOOOOOOOOOO', 'YYOOOOOOOOO', 'YYROOOOOOOO', 'YYRYOOOOOOO',
            'YYRYYOOOOOO', 'YYRYYROOOOO', 'YYRYYRYOOOO', 'YYRYYRYYOOO', 'YYRYYRYYROO', 'YYRYYRYYRYO', 'YYRYYRYYRYY']
    final ONE_MINUTE_LINE_CONFIGURATION = ['OOOO', 'YOOO', 'YYOO', 'YYYO', 'YYYY']

    String toString() {
        twoSecondsLine() + ' ' + fiveHoursLine() + ' ' + oneHourLine() + ' ' + fiveMinutesLine() + ' ' + oneMinuteLine()
    }

    String twoSecondsLine() {
        TimeUtils.toSeconds(hours, minutes, seconds) % 2 == 0 ? 'Y' : 'O'
    }

    String fiveHoursLine() {
        HOURS_LINE_CONFIGURATION[TimeUtils.fiveHoursGroups(hours)]
    }

    String oneHourLine() {
        HOURS_LINE_CONFIGURATION[TimeUtils.oneHourGroups(hours)]
    }

    String fiveMinutesLine() {
        FIVE_MINUTES_LINE_CONFIGURATION[TimeUtils.fiveMinutesGroups(hours, minutes)]
    }

    String oneMinuteLine() {
        ONE_MINUTE_LINE_CONFIGURATION[TimeUtils.oneMinuteGroups(hours, minutes)]
    }
}
