package es.basallo;

class TimeUtils {

    public static int parsedHoursFromInput(String input) {
        return Integer.parseInt(input.split(":")[0]);
    }

    public static int parsedMinutesFromInput(String input) {
        return Integer.parseInt(input.split(":")[1]);
    }

    public static int parsedSecondsFromInput(String input) {
        return Integer.parseInt(input.split(":")[2]);
    }

    public static int toMinutes(int hours, int minutes) {
        return minutes + 60 * hours;
    }

    public static int toSeconds(int hours, int minutes, int seconds) {
        return seconds + 60 * toMinutes(hours, minutes);
    }

    public static int fiveHoursGroups(int hours) {
        return hours / 5;
    }

    public static int oneHourGroups(int hours) {
        return hours % 5;
    }

    private static int minutesExpressedAsHours(int hours) {
        return (5 * fiveHoursGroups(hours) + oneHourGroups(hours)) * 60;
    }

    public static int fiveMinutesGroups(int hours, int minutes) {
        return (toMinutes(hours, minutes) - minutesExpressedAsHours(hours)) / 5;
    }

    public static int oneMinuteGroups(int hours, int minutes) {
        return (toMinutes(hours, minutes) - minutesExpressedAsHours(hours)) % 5;
    }
}
