package laullobet.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.Format;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeAgoMessageFormatterShould {

    @Mock
    private Clock clock;
    @Mock
    private Message message;

    @Test
    public void
    add_to_the_end_of_the_message_how_many_minutes_ago_on_it() {
        when(clock.getCurrentTimeMillis()).thenReturn(0);
        when(message.getTimestamp()).thenReturn(-5*60*1000);

        TimeAgoMessageFormatter formatter = new TimeAgoMessageFormatter(clock);

        String messageString = formatter.format(message);

        assertThat(messageString,is("hola 5 minutes ago"));
    }
}
