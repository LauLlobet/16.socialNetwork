package laullobet.org;

import java.util.ArrayList;
import java.util.List;
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

    public ArrayList<Message> getAllFrom(ArrayList<String> strings) {
        throw new UnsupportedOperationException();
    }
}
