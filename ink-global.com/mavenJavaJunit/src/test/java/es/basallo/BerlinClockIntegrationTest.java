package es.basallo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BerlinClockIntegrationTest {

    private String input;
    private String result;

    public BerlinClockIntegrationTest(String input, String result) {
        this.input = input;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection berlinClockIntegration() {
        return Arrays.asList(new Object[][]{
                {"00:00:00", "Y OOOO OOOO OOOOOOOOOOO OOOO"},
                {"13:17:01", "O RROO RRRO YYROOOOOOOO YYOO"},
                {"23:59:59", "O RRRR RRRO YYRYYRYYRYY YYYY"},
                {"24:00:00", "Y RRRR RRRR OOOOOOOOOOO OOOO"}
        });
    }

    @Test
    public void fullIntegrationWithGivenTestData() {

        BerlinClock berlinClock = new BerlinClock(TimeUtils.parsedHoursFromInput(input),
                TimeUtils.parsedMinutesFromInput(input), TimeUtils.parsedSecondsFromInput(input)); // Setup

        assertTrue(berlinClock.toString().equals(result)); // Expect
    }
}