package es.basallo

class TimeUtils {

    static def parsedMapFromInput(String input) {
        def tokenizedInput = input.tokenize ':'
        def parsedHours = Integer.parseInt tokenizedInput[0]
        def parsedMinutes = Integer.parseInt tokenizedInput[1]
        def parsedSeconds = Integer.parseInt tokenizedInput[2]
        [hours: parsedHours, minutes: parsedMinutes, seconds: parsedSeconds]
    }

    static int toMinutes(Integer hours, Integer minutes) {
        minutes + 60 * hours
    }

    static int toSeconds(Integer hours, Integer minutes, Integer seconds) {
        seconds + 60 * toMinutes(hours, minutes)
    }

    static int fiveHoursGroups(Integer hours) {
        hours / 5
    }

    static int oneHourGroups(Integer hours) {
        hours % 5
    }

    static private int minutesExpressedAsHours(Integer hours) {
        (5 * fiveHoursGroups(hours) + oneHourGroups(hours)) * 60
    }

    static int fiveMinutesGroups(Integer hours, Integer minutes) {
        (toMinutes(hours, minutes) - minutesExpressedAsHours(hours)) / 5
    }

    static int oneMinuteGroups(Integer hours, Integer minutes) {
        (toMinutes(hours, minutes) - minutesExpressedAsHours(hours)) % 5
    }
}
