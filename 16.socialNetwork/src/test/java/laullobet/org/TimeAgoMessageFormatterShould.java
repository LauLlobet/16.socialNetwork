package laullobet.org;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeAgoMessageFormatterShould {

    @Mock
    private Clock clock;
    @Mock
    private Message message;
    private TimeAgoMessageFormatter formatter;

    @Before
    public void set_up() {
        formatter = new TimeAgoMessageFormatter(clock);
    }

    @Test
    public void
    concatenate_the_message_with_how_many_minutes_past_from_its_timestamp() {
        when(clock.getCurrentTimeMillis()).thenReturn(0);
        when(message.getTimestamp()).thenReturn(-5*60*1000);
        when(message.getMessageBody()).thenReturn("hola");

        String messageString = formatter.format(message);

        assertThat(messageString,is("hola 5 minutes ago"));
    }

    @Test
    public void
    concatenate_the_message_with_how_many_seconds_past_from_its_timestamp() {
        when(clock.getCurrentTimeMillis()).thenReturn(0);
        when(message.getTimestamp()).thenReturn(-5*1000);
        when(message.getMessageBody()).thenReturn("hola");

        String messageString = formatter.format(message);

        assertThat(messageString,is("hola 5 seconds ago"));
    }
}
