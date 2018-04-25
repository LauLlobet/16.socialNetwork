package laullobet.org;

public class CommandFactory {
    protected final MessagePrinter messagePrinter;
    protected final MessageRepository messageRepository;
    private final MessageFactory messageFactory;
    protected final Console console;
    private FollowedRepository followedRepository;

    public CommandFactory( MessagePrinter messagePrinter,
                          MessageRepository messageRepository,
                           MessageFactory messageFactory,
                           Console console,
                           FollowedRepository followedRepository) {
        this.messagePrinter = messagePrinter;
        this.messageRepository = messageRepository;
        this.messageFactory = messageFactory;
        this.console = console;
        this.followedRepository = followedRepository;
    }

    public Command createCommand(String line){
        String[] splitedLine = line.split(" ");
        if(splitedLine[1].equals("follows")){
            return new CreateFollowerComand(line, followedRepository);
        }
        if(splitedLine.length == 2 && splitedLine[1].equals("wall")){
            return new PrintWallCommand(line,messageRepository,followedRepository,messagePrinter);
        }
        if(line.contains("->")){
            return new CreateMessageCommand(line,messageRepository,messageFactory);
        }
        return new PrintMessagesCommand(line,messagePrinter,messageRepository);
    }
}
