package laullobet.org;

public class CreateMessageCommand extends Command {

    private final MessageRepository messageRepository;
    private final MessageFactory messageFactory;
    private final MessageFactory messageFactor;

    CreateMessageCommand(String line, MessageRepository messageRepository, MessageFactory messageFactory) {
        super(line);
        this.messageRepository = messageRepository;
        this.messageFactory = messageFactory;
        this.messageFactor = messageFactory;
    }

    @Override
    public void execute() {
        String[] parts = line.split(" -> ");
        messageRepository.add(messageFactory.createMessage(parts[0], parts[1]));
    }
}
