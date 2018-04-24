package laullobet.org;

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
}
