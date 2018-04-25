package laullobet.org;

public class PrintMessagesCommand extends Command {
    private final MessagePrinter messagePrinter;
    private final MessageRepository messageRepository;

    PrintMessagesCommand(String line, MessagePrinter messagePrinter, MessageRepository messageRepository) {
        super(line);
        this.messagePrinter = messagePrinter;
        this.messageRepository = messageRepository;
    }

    @Override
    public void execute() {
        messageRepository
                .getAllFrom(line)
                .forEach(messagePrinter::printMessage);
    }
}
