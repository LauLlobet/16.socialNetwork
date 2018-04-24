package laullobet.org;

public class SocialNetwork {
    private final Console console;
    private final MessageRepository messageRepository;
    private TimeAgoMessageFormatter messageFormatter;
    private Clock clock;

    public SocialNetwork(Console console, MessageRepository messageRepository, TimeAgoMessageFormatter messageFormatter, Clock clock) {
        this.console = console;
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
                    .map(m -> messageFormatter.format(m))
                    .forEach(str -> console.printLine(str));
        }
    }
}
