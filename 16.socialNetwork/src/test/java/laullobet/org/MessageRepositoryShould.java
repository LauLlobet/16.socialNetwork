package laullobet.org;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MessageRepositoryShould {
    @Test
    public void
    allow_store_messages_and_retrive_all_message_from_name() {

        MessageRepository messageRepository = new MessageRepository();
        messageRepository.add(new Message("Marc","m1",0));
        messageRepository.add(new Message("John","m2",0));
        messageRepository.add(new Message("Marc","m3",0));
        messageRepository.add(new Message("Marc","m4",0));

        List<Message> list = messageRepository.getAllFrom("Marc");

        list.stream()
                .map(x -> x.getUser())
                .forEach(username -> assertEquals(username,"Marc"));
        assertThat(list.size(),is(3));
    }
}
