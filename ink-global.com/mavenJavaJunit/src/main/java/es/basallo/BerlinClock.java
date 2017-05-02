package es.basallo;

public class BerlinClock {

    private static final String[] HOURS_LINE_CONFIGURATION = {"OOOO", "ROOO", "RROO", "RRRO", "RRRR"};
    private static final String[] FIVE_MINUTES_LINE_CONFIGURATION = {"OOOOOOOOOOO", "YOOOOOOOOOO", "YYOOOOOOOOO", "YYROOOOOOOO",
            "YYRYOOOOOOO", "YYRYYOOOOOO", "YYRYYROOOOO", "YYRYYRYOOOO", "YYRYYRYYOOO", "YYRYYRYYROO", "YYRYYRYYRYO", "YYRYYRYYRYY"};
    private static final String[] ONE_MINUTE_LINE_CONFIGURATION = {"OOOO", "YOOO", "YYOO", "YYYO", "YYYY"};

    int hours;
    int minutes;
    int seconds;

    public BerlinClock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String toString() {
        return twoSecondsLine() + " " + fiveHoursLine() + " " + oneHourLine() + " " + fiveMinutesLine() + " " + oneMinuteLine();
    }

    public String twoSecondsLine() {
        return TimeUtils.toSeconds(hours, minutes, seconds) % 2 == 0 ? "Y" : "O";
    }

    public String fiveHoursLine() {
        return HOURS_LINE_CONFIGURATION[TimeUtils.fiveHoursGroups(hours)];
    }

    public String oneHourLine() {
        return HOURS_LINE_CONFIGURATION[TimeUtils.oneHourGroups(hours)];
    }

    public String fiveMinutesLine() {
        return FIVE_MINUTES_LINE_CONFIGURATION[TimeUtils.fiveMinutesGroups(hours, minutes)];
    }

    public String oneMinuteLine() {
        return ONE_MINUTE_LINE_CONFIGURATION[TimeUtils.oneMinuteGroups(hours, minutes)];
    }

}
