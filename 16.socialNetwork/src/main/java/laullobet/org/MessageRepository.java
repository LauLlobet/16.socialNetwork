package laullobet.org;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MessageRepository {
    private List<Message> list = new ArrayList<>();

    public void add(Message message){
        list.add(message);
    }

    public List<Message> getAllFrom(String user) {
        return list.stream()
                .filter(message -> message.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public List<Message> getAllFrom(Set<String> users) {
        return list.stream()
                .filter(message -> users.contains(message.getUser()))
                .sorted(Comparator.comparingInt(Message::getTimestamp))
                .collect(Collectors.toList());
    }
}
