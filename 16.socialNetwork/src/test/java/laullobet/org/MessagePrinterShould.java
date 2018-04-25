package laullobet.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MessagePrinterShould {

    @Mock
    private Message message;
    @Mock
    private Console console;
    @Mock
    AuthorAndTimeAgoMessageFormatter authorAndTimeAgoMessageFormatter;

    private MessagePrinter messagePrinter;

    @Test
    public void
    print_several_messages_with_author() {
        List<Message> messages = new ArrayList<Message>(){{
            add(message);
            add(message);
            add(message);
        }};
        messagePrinter = new MessagePrinter(null, authorAndTimeAgoMessageFormatter, console);

        messagePrinter.printMessagesWithAuthor(messages);

        verify(authorAndTimeAgoMessageFormatter,times(3)).format(any(Message.class));
    }
}
