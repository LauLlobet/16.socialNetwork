package laullobet.org;

public class SocialNetwork {
    private final Console console;
    private final MessageRepository messageRepository;

    public SocialNetwork(Console console, MessageRepository messageRepository) {
        this.console = console;
        this.messageRepository = messageRepository;
    }

    public void run() {
        String line = console.readLine();
        if(line.contains(" -> ")) {
            String[] parts = line.split(" -> ");
            messageRepository.save(new Message(parts[0], parts[1]));
        }else{
            messageRepository
                    .getAllFrom(line)
                    .stream()
                    .forEach(message -> console.printLine(message.getMessageBody()));
        }
    }
}
