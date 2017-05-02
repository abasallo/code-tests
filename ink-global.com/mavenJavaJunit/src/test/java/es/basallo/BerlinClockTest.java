package es.basallo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BerlinClockTest {

    private int hours;
    private int minutes;
    private int seconds;

    private String twoSecondsLineResult;
    private String fiveHoursLineResult;
    private String oneHourLineResult;
    private String fiveMinutesLineResult;
    private String oneMinuteLineResult;

    private BerlinClock berlinClock;

    public BerlinClockTest(int hours, int minutes, int seconds, String twoSecondsLineResult, String fiveHoursLineResult,
                           String oneHourLineResult, String fiveMinutesLineResult, String oneMinuteLineResult) {

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.twoSecondsLineResult = twoSecondsLineResult;
        this.fiveHoursLineResult = fiveHoursLineResult;
        this.oneHourLineResult = oneHourLineResult;
        this.fiveMinutesLineResult = fiveMinutesLineResult;
        this.oneMinuteLineResult = oneMinuteLineResult;
    }

    @Parameterized.Parameters
    public static Collection berlinClock() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0, "Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"},
                {13, 17, 1, "O", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"},
                {23, 59, 59, "O", "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY"},
                {24, 0, 0, "Y", "RRRR", "RRRR", "OOOOOOOOOOO", "OOOO"}
        });
    }

    @Before
    public void initialize() {
        berlinClock = new BerlinClock(hours, minutes, seconds); // Setup
    }

    @Test
    public void firstLineTheLightBlinksYellowEveryTwoSecond() {
        assertTrue(berlinClock.twoSecondsLine() == twoSecondsLineResult); // Expect
    }

    @Test
    public void secondLineEveryRedLightRepresentsFiveHours() {
        assertTrue(berlinClock.fiveHoursLine() == fiveHoursLineResult); // Expect
    }

    @Test
    public void thirdLineEveryRedLightIsAnHour() {
        assertTrue(berlinClock.oneHourLine() == oneHourLineResult); // Expect
    }

    @Test
    public void fourthLineEveryYellowLightRepresentsFiveMinutesThoseCorrespondingToQuartersAreRed() {
        assertTrue(berlinClock.fiveMinutesLine() == fiveMinutesLineResult); // Expect
    }

    @Test
    public void fifthLineEveryYellowLightIsAMinute() {
        assertTrue(berlinClock.oneMinuteLine() == oneMinuteLineResult); // Expect
    }
}











 
 
