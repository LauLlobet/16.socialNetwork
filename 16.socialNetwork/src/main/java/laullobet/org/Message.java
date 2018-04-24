package laullobet.org;

import java.util.Objects;

public class Message {
    private final String user;
    private final String messageBody;
    private int timestamp;

    public Message(String user, String messageBody, int timestamp) {
        this.user = user;
        this.messageBody = messageBody;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(user, message.user) &&
                Objects.equals(messageBody, message.messageBody);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, messageBody);
    }

    public String getMessageBody() {
        return messageBody;
    }

    public String getUser() {
        return user;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
