package laullobet.org.features;

import laullobet.org.*;
import laullobet.org.Commands.CommandFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WallFeature {

    @Mock
    Clock clock;
    @Mock
    Console console;
    @Mock
    MessagePrinter messagePrinter;
    @Mock
    MessageRepository messageRepository;


    SocialNetwork socialNetwork;

    @Before
    public void getCommandFactory() {
        MessagePrinter messagePrinter = new MessagePrinter(new TimeAgoMessageFormatter(clock),
                new AuthorAndTimeAgoMessageFormatter(clock), console);

        MessageFactory messageFactory = new MessageFactory(clock);
        CommandFactory commandFactory;
        FollowedRepository followersRepository = new FollowedRepository();
        commandFactory = new CommandFactory(messagePrinter,new MessageRepository(),
                messageFactory, console, followersRepository);
        socialNetwork = new SocialNetwork(commandFactory, console);
    }


    @Test
    public void
    prints_a_wall_of_followers_and_itself() {
        when(console.readLine())
                .thenReturn("Charlie -> I'm in New York today! Anyone wants to have a coffee?")
                .thenReturn("Charlie follows Bob")
                .thenReturn("Bob -> Good game though.")
                .thenReturn("Charlie wall");

        when(clock.getCurrentTimeMillis())
                .thenReturn(0);

        socialNetwork.run();
        socialNetwork.run();
        socialNetwork.run();
        socialNetwork.run();

        verify(console).printMessage("Charlie - I'm in New York today! Anyone wants to have a coffee? (0 seconds ago)");
        verify(console).printMessage("Bob - Good game though. (0 seconds ago)");
    }
}
