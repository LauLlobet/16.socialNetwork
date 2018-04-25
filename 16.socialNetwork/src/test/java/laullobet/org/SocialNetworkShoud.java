package laullobet.org;

import laullobet.org.Commands.CommandFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SocialNetworkShoud {
    @Mock
    private MessageRepository messageRepository;
    private SocialNetwork socialNetwork;
    @Mock
    private MessagePrinter messagePrinter;
    private Clock clock;

    @Mock
    private Console console;
    @Mock
    private FollowedRepository followedRepository;

    @Mock
    private Message aliceMessage2, aliceMessage1, bobMessage1;

    @Before
    public void set_up() {
        clock = new Clock();
        MessageFactory messageFactory = new MessageFactory(clock);
        CommandFactory commandFactory = new CommandFactory(messagePrinter, messageRepository, messageFactory, console, followedRepository);
        socialNetwork = new SocialNetwork(commandFactory, console);
    }

    @Test
    public void
    save_messages() {
        when(console.readLine()).thenReturn("Bob -> Hola");

        socialNetwork.run();

        verify(messageRepository).add(new Message("Bob", "Hola", 0));
    }

    @Test
    public void
    print_all_messages_from_one_user() {
        Message m1 = new Message("Alice", "Bien", 0);
        Message m2 = new Message("Alice", "Muy Bien", 0);
        when(messageRepository.getAllFrom("Alice")).thenReturn(new ArrayList<Message>() {{
            add(m1);
            add(m2);
        }});

        when(console.readLine()).thenReturn("Alice");

        socialNetwork.run();

        verify(messagePrinter).printMessage(m1);
        verify(messagePrinter).printMessage(m2);
    }

    @Test
    public void
    store_the_follower_in_repository() {
        when(console.readLine()).thenReturn("Alice follows Bob");

        socialNetwork.run();

        verify(followedRepository).add("Alice", "Bob");
    }

    @Test
    public void
    call_the_printer_with_followed_messages_including_the_user_ones() {
        ArrayList<String> followedIncludingSelf = new ArrayList<String>(){{
            add("Ann");
            add("Bob");
            add("Alice");
        }};
        ArrayList<Message> wallMessages = new ArrayList<Message>() {{
            add(aliceMessage1);
        }};

        when(console.readLine()).thenReturn("Alice wall");
        when(followedRepository.getFollowedWithItself("Alice")).thenReturn(followedIncludingSelf);
        when(messageRepository.getAllFrom(followedIncludingSelf)).thenReturn(wallMessages);

        socialNetwork.run();

        verify(messagePrinter).printMessagesWithAuthor(wallMessages);
    }


}
