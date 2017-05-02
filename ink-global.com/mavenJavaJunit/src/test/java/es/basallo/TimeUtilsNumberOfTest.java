package es.basallo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TimeUtilsNumberOfTest {

    private int hours;
    private int minutes;
    private int seconds;

    private int numberOfMinutes;
    private int numberOfSeconds;
    private int numberOfFiveHoursGroups;
    private int numberOfOneHourGroups;
    private int numberOfFiveMinutesGroups;
    private int numberOfOneMinuteGroups;

    public TimeUtilsNumberOfTest(int hours, int minutes, int seconds, int numberOfMinutes, int numberOfSeconds,
                                 int numberOfFiveHoursGroups, int numberOfOneHourGroups, int numberOfFiveMinutesGroups,
                                 int numberOfOneMinuteGroups) {

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.numberOfMinutes = numberOfMinutes;
        this.numberOfSeconds = numberOfSeconds;
        this.numberOfFiveHoursGroups = numberOfFiveHoursGroups;
        this.numberOfOneHourGroups = numberOfOneHourGroups;
        this.numberOfFiveMinutesGroups = numberOfFiveMinutesGroups;
        this.numberOfOneMinuteGroups = numberOfOneMinuteGroups;
    }

    @Parameterized.Parameters
    public static Collection timeUtilsNumberOf() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {13, 17, 1, 797, 47821, 2, 3, 3, 2},
                {23, 59, 59, 1439, 86399, 4, 3, 11, 4},
                {24, 0, 0, 1440, 86400, 4, 4, 0, 0}
        });
    }

    @Test
    public void numberOfMinutesInAGivenTime() {
        assertTrue(TimeUtils.toMinutes(hours, minutes) == numberOfMinutes); // Expect
    }

    @Test
    public void numberOfSecondsInAGivenTime() {
        assertTrue(TimeUtils.toSeconds(hours, minutes, seconds) == numberOfSeconds); // Expect
    }

    @Test
    public void numberOfFiveHoursGroupsInAGivenTime() {
        assertTrue(TimeUtils.fiveHoursGroups(hours) == numberOfFiveHoursGroups); // Expect
    }

    @Test
    public void numberOfOneHourGroupsInAGivenTime() {
        assertTrue(TimeUtils.oneHourGroups(hours) == numberOfOneHourGroups); // Expect
    }

    @Test
    public void numberOfFiveMinutesGroupsInAGivenTime() {
        assertTrue(TimeUtils.fiveMinutesGroups(hours, minutes) == numberOfFiveMinutesGroups); // Expect
    }

    @Test
    public void numberOfOneMinuteGroupsInAGivenTime() {
        assertTrue(TimeUtils.oneMinuteGroups(hours, minutes) == numberOfOneMinuteGroups); // Expect
    }
}
