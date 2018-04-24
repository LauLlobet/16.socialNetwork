package laullobet.org;

public class SocialNetwork {
    private final Console console;
    private final MessagePrinter messagePrinter;
    private final MessageRepository messageRepository;
    private TimeAgoMessageFormatter messageFormatter;
    private MessageFactory messageFactory;

    public SocialNetwork(Console console, MessagePrinter messagePrinter,
                         MessageRepository messageRepository,
                         MessageFactory messageFactory) {
        this.console = console;
        this.messagePrinter = messagePrinter;
        this.messageRepository = messageRepository;
        this.messageFormatter = messageFormatter;
        this.messageFactory = messageFactory;
    }

    public void run() {
        String line = console.readLine();
        if(line.contains(" -> ")) {
            String[] parts = line.split(" -> ");
            messageRepository.add(messageFactory.createMessage(parts[0], parts[1]));
        }else{
            messageRepository
                    .getAllFrom(line)
                    .stream()
                    .forEach(m -> messagePrinter.printMessage(m));
        }
    }
}
