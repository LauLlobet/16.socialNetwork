package laullobet.org;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

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

    @Before
    public void set_up() {
        clock = new Clock();
        socialNetwork = new SocialNetwork(console, messagePrinter,
                messageRepository,
                clock);
    }

    @Test
    public void
    save_messages() {
        when(console.readLine()).thenReturn("Bob -> Hola");

        socialNetwork.run();

        verify(messageRepository).add(new Message("Bob", "Hola",0));
    }

    @Test
    public void
    print_all_messages_from_one_user() {
        Message m1 = new Message("Alice", "Bien", 0);
        Message m2 = new Message("Alice", "Muy Bien", 0);
        when(messageRepository.getAllFrom("Alice")).thenReturn(new ArrayList<Message>(){{
            add(m1);
            add(m2);
        }});

        when(console.readLine()).thenReturn("Alice");

        socialNetwork.run();

        verify(messagePrinter).printMessage(m1);
        verify(messagePrinter).printMessage(m2);
    }


    private class NoFormatFormatter extends TimeAgoMessageFormatter {
        public NoFormatFormatter(Clock clock) {
            super(clock);
        }

        @Override
        public String format(Message m){
            return m.getMessageBody();
        }
    }
}
