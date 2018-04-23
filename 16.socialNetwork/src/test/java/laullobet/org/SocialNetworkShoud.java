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
    private Console console;

    @Before
    public void set_up() {
        socialNetwork = new SocialNetwork(console, messageRepository);
    }

    @Test
    public void
    save_messages() {
        when(console.readLine()).thenReturn("Bob -> Hola");

        socialNetwork.run();

        verify(messageRepository).save(new Message("Bob", "Hola"));
    }

    @Test
    public void
    print_all_messages_from_one_user() {
        when(messageRepository.getAllFrom("Bob")).thenReturn(new ArrayList<Message>(){{
            add(new Message("Bob","Hola"));
        }});
        when(messageRepository.getAllFrom("Alice")).thenReturn(new ArrayList<Message>(){{
            add(new Message("Alice","Bien"));
            add(new Message("Alice","Muy Bien"));
        }});
        when(console.readLine()).thenReturn("Bob").thenReturn("Alice");

        socialNetwork.run();
        socialNetwork.run();

        verify(console).printLine("Hola");
        verify(console).printLine("Bien");
        verify(console).printLine("Muy Bien");
    }
}
