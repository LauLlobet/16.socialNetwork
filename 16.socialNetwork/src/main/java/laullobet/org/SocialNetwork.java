package laullobet.org;

public class SocialNetwork {
    private final Console console;
    private final MessagePrinter messagePrinter;
    private final MessageRepository messageRepository;
    private TimeAgoMessageFormatter messageFormatter;
    private Clock clock;

    public SocialNetwork(Console console, MessagePrinter messagePrinter, MessageRepository messageRepository, Clock clock) {
        this.console = console;
        this.messagePrinter = messagePrinter;
        this.messageRepository = messageRepository;
        this.messageFormatter = messageFormatter;
        this.clock = clock;
    }

    public void run() {
        String line = console.readLine();
        if(line.contains(" -> ")) {
            String[] parts = line.split(" -> ");
            messageRepository.add(new Message(parts[0], parts[1],clock.getCurrentTimeMillis()));
        }else{
            messageRepository
                    .getAllFrom(line)
                    .stream()
                    .forEach(m -> messagePrinter.printMessage(m));
        }
    }
}
