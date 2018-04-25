package laullobet.org;

public class MessageFactory {


    private Clock clock;

    MessageFactory(Clock clock) {
        this.clock = clock;
    }

    public Message createMessage(String user, String message) {
        return  new Message(user,message,clock.getCurrentTimeMillis());
    }
}
