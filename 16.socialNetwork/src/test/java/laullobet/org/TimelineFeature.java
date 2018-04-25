package laullobet.org;

import org.junit.Before;
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
    @Mock
    private Clock clock;

    @Before
    public void getCommandFactory() {
        MessagePrinter messagePrinter = new MessagePrinter(new TimeAgoMessageFormatter(clock), console);
        MessageFactory messageFactory = new MessageFactory(clock);
        CommandFactory commandFactory;
        FollowedRepository followersRepository = new FollowedRepository();
        commandFactory = new CommandFactory(messagePrinter,new MessageRepository(),
                messageFactory, console, followersRepository);
        socialNetwork = new SocialNetwork(commandFactory, console);
    }

    @Test
    public void display_timeline_by_user() {

        when(console.readLine())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("Bob -> Good game though.")
                .thenReturn("Bob -> Damn! We lost!")
                .thenReturn("Alice")
                .thenReturn("Bob");

        when(clock.getCurrentTimeMillis())
                .thenReturn(-5*60*1000)
                .thenReturn(-2*1000)
                .thenReturn(-2*60*1000)
                .thenReturn(0);

        socialNetwork.run();
        socialNetwork.run();
        socialNetwork.run();
        socialNetwork.run();
        socialNetwork.run();

        verify(console).printMessage("I love the weather today (5 minutes ago)");
        verify(console).printMessage("Good game though. (2 seconds ago)");
        verify(console).printMessage("Damn! We lost! (2 minutes ago)");
    }


    @Test
    public void
    prints_a_wall_of_followers_and_itself() {
        when(console.readLine())
                .thenReturn("Charlie -> I'm in New York today! Anyone wants to have a coffee?")
                .thenReturn("Bob -> Good game though.")
                .thenReturn("Charlie follows Bob")
                .thenReturn("Charlie wall");

        when(clock.getCurrentTimeMillis())
                .thenReturn(0);

        socialNetwork.run();
        socialNetwork.run();

        verify(console).printMessage("Charlie - I'm in New York today! Anyone wants to have a coffee? (0 seconds ago)");
        verify(console).printMessage("Bob - Good game though. (0 seconds ago)");
    }
}
