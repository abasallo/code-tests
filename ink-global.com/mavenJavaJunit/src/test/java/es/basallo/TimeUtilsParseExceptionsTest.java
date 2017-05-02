package es.basallo;

import org.junit.Test;

public class TimeUtilsParseExceptionsTest {

    @Test(expected = NumberFormatException.class)
    public void parsedHoursFromInputString() {
        TimeUtils.parsedHoursFromInput("AA:00:00"); // Expect
    }

    @Test(expected = NumberFormatException.class)
    public void parsedMinutesFromInputString() {
        TimeUtils.parsedMinutesFromInput("00:AA:00"); // Expect
    }

    @Test(expected = NumberFormatException.class)
    public void parsedSecondsFromInputString() {
        TimeUtils.parsedSecondsFromInput("00:00:AA"); // Expect
    }
}


