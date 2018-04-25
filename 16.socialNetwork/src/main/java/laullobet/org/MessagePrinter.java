package laullobet.org;

import java.util.List;

public class MessagePrinter {
    private final TimeAgoMessageFormatter timeAgoMessageFormatter;
    private final AuthorAndTimeAgoMessageFormatter authorFormatter;
    private final Console console;

    public MessagePrinter(TimeAgoMessageFormatter timeAgoMessageFormatter, AuthorAndTimeAgoMessageFormatter authorFormatter, Console console) {
        this.timeAgoMessageFormatter = timeAgoMessageFormatter;
        this.authorFormatter = authorFormatter;
        this.console = console;
    }

    public void printMessage(Message message) {
        console.printMessage(timeAgoMessageFormatter.format(message));
    }

    public void printMessagesWithAuthor(List<Message> messages) {
        messages.stream()
                .map(message -> authorFormatter.format(message)).forEach(x -> System.out.println(x));
    }
}
