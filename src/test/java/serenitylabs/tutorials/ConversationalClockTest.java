package serenitylabs.tutorials;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.runner.RunWith;
import org.hamcrest.Matchers;

import java.time.LocalTime;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZohhakRunner.class)
public class ConversationalClockTest {

    @TestWith({
            "01:00, it's one o'clock",
    })
    public void should_tell_the_time_on_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    ConversationalClockDisplayer conversationalClockDisplayer;
    String conversationalTime;

    //  the Clock tell the time on an hour ("it's one o'clock", "it's two o'clock")
    @TestWith({
            "01,00, it's one o'clock",
            "02,00, it's two o'clock",
            "11,00, it's eleven o'clock"

    })
    public void should_clock_tell_the_time_on_an_hour(int hour, int minutes, String expectedTime) throws Exception {
        conversationalTimeFromClock(hour, minutes, expectedTime);
    }

    @TestWith({
            "12,00, it's noon",
            "00,00, it's midnight",
    })
    public void should_display_noon_and_midnight_in_conversational_time(int hour, int minutes, String expectedTime) throws Exception {
        conversationalTimeFromClock(hour, minutes, expectedTime);
    }


    @TestWith({
            "12,30, it's half past twelve",
            "2,30, it's half past two"

    })
    public void should_display_past_thirty_in_conversational_time(int hour, int minutes, String expectedTime) throws Exception {
        conversationalTimeFromClock(hour, minutes, expectedTime);
    }

    // telling the time with a minute precision ("it's seven past eight", "it's fifty three past five")
    @TestWith({
            "8,07, it's seven past eight",
            // "5,53, it's fifty three past five"
    })
    public void should_display_past_in_conversational_time(int hour, int minutes, String expectedTime) throws Exception {
        conversationalTimeFromClock(hour, minutes, expectedTime);
    }


    @TestWith({
            "13,58, it's almost two o'clock"
    })
    public void should_display_almost_in_conversational_time(int hour, int minutes, String expectedTime) throws Exception {
        conversationalTimeFromClock(hour, minutes, expectedTime);
    }

    @TestWith({
            "14,01, it's just after two o'clock"
    })
    public void should_display_just_after_in_conversational_time(int hour, int minutes, String expectedTime) throws Exception {
        conversationalTimeFromClock(hour, minutes, expectedTime);
    }

    @TestWith({
            "12,15, it's quarter past twelve",
            "14,45, it's quarter to three"
    })
    public void should_display_quarters_in_conversational_time(int hour, int minutes, String expectedTime) throws Exception {
        conversationalTimeFromClock(hour, minutes, expectedTime);
    }

    //tell the time relative to the hour that's "closer" - "it's seven to nine"
    @TestWith({
            "8,53, it's seven to nine",
            "14,50, it's ten to three"
    })
    public void should_display_relative_to_the_hour_that_is_closer_in_conversational_time(int hour, int minutes, String expectedTime) throws Exception {
        conversationalTimeFromClock(hour, minutes, expectedTime);
    }


    private void conversationalTimeFromClock(int hour, int minutes, String expectedTime) {
        conversationalClockDisplayer = new ConversationalClockDisplayer(() -> LocalTime.of(hour, minutes));
        conversationalTime = conversationalClockDisplayer.showTime();

        MatcherAssert.assertThat(conversationalTime, Matchers.is(expectedTime));
    }
}
