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


    @Test
    public void display_timeline_by_user() {
        socialNetwork = new SocialNetwork(console, new MessageRepository());
        when(console.readLine())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("Bob -> Good game though.")
                .thenReturn("Bob -> Damn! We lost!")
                .thenReturn("Alice")
                .thenReturn("Bob");

        socialNetwork.run();
        socialNetwork.run();
        socialNetwork.run();
        socialNetwork.run();
        socialNetwork.run();

        verify(console).printLine("I love the weather today (5 minutes ago)");
        verify(console).printLine("Good game though. (1 minute ago)");
        verify(console).printLine("Damn! We lost! (2 minutes ago)");
    }
}
