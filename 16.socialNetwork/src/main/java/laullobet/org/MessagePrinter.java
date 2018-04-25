package laullobet.org;

import java.util.List;

public class MessagePrinter {
    private final TimeAgoMessageFormatter timeAgoMessageFormatter;
    private final Console console;

    public MessagePrinter(TimeAgoMessageFormatter timeAgoMessageFormatter, Console console) {
        this.timeAgoMessageFormatter = timeAgoMessageFormatter;
        this.console = console;
    }

    public void printMessage(Message message) {
        console.printMessage(timeAgoMessageFormatter.format(message));
    }

    public void printMessageWithAuthor(Message message) {
        throw new UnsupportedOperationException();
    }

    public void printMessagesWithAuthor(List<Message> messages) {
        throw new UnsupportedOperationException();
    }
}
