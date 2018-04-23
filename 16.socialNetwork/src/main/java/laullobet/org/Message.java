package laullobet.org;

import java.util.Objects;

public class Message {
    private final String user;
    private final String messageBody;

    public Message(String user, String messageBody) {
        this.user = user;
        this.messageBody = messageBody;
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
}
