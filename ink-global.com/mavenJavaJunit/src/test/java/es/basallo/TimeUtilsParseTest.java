package es.basallo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TimeUtilsParseTest {

    private String input;

    private int resultHours;
    private int resultMinutes;
    private int resultSeconds;

    public TimeUtilsParseTest(String input, int resultHours, int resultMinutes, int resultSeconds) {
        this.input = input;
        this.resultHours = resultHours;
        this.resultMinutes = resultMinutes;
        this.resultSeconds = resultSeconds;
    }

    @Parameterized.Parameters
    public static Collection timeUtilsParse() {
        return Arrays.asList(new Object[][]{
                {"00:00:00", 0, 0, 0},
                {"00:00:00", 0, 0, 0},
                {"00:00:00", 0, 0, 0},
                {"00:00:00", 0, 0, 0},
                {"13:17:01", 13, 17, 1},
                {"23:59:59", 23, 59, 59},
                {"24:00:00", 24, 0, 0}
        });
    }

    @Test
    public void parsedHoursFromInputString() {
        assertTrue(TimeUtils.parsedHoursFromInput(input) == resultHours); // Expect
    }

    @Test
    public void parsedMinutesFromInputString() {
        assertTrue(TimeUtils.parsedMinutesFromInput(input) == resultMinutes); // Expect
    }

    @Test
    public void parsedSecondsFromInputString() {
        assertTrue(TimeUtils.parsedSecondsFromInput(input) == resultSeconds); // Expect
    }
}
