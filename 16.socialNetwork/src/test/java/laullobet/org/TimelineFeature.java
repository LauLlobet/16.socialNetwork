package laullobet.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimelineFeature {
    @Mock
    Console console;

    private SocialNetwork socialNetwork;
    private Clock clock;


    @Test
    public void display_timeline_by_user() {
        clock = new Clock();
        MessagePrinter messagePrinter = new MessagePrinter(new TimeAgoMessageFormatter(clock), console);
        socialNetwork = new SocialNetwork(console, messagePrinter, new MessageRepository(), new MessageFactory());
        when(console.readLine())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("Bob -> Good game though.")
                .thenReturn("Bob -> Damn! We lost!")
                .thenReturn("Alice")
                .thenReturn("Bob");

        clock.setCurrentTimeMillis(-5*60*1000);
        socialNetwork.run();

        clock.setCurrentTimeMillis(-2*1000);
        socialNetwork.run();

        clock.setCurrentTimeMillis(-2*60*1000);
        socialNetwork.run();

        clock.setCurrentTimeMillis(0);
        socialNetwork.run();
        socialNetwork.run();

        verify(console).printMessage("I love the weather today (5 minutes ago)");
        verify(console).printMessage("Good game though. (2 seconds ago)");
        verify(console).printMessage("Damn! We lost! (2 minutes ago)");
    }
}
