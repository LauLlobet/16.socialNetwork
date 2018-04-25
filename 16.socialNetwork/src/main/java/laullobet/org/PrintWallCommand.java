package laullobet.org;

import java.util.ArrayList;

public class PrintWallCommand extends Command {
    private final MessageRepository messageRepository;
    private final FollowedRepository followedRepository;
    private final MessagePrinter messagePrinter;

    public PrintWallCommand(String line, MessageRepository messageRepository, FollowedRepository followedRepository, MessagePrinter messagePrinter) {
        super(line);
        this.messageRepository = messageRepository;
        this.followedRepository = followedRepository;
        this.messagePrinter = messagePrinter;
    }

    @Override
    public void execute(){ //TODO: test knows all from the implementation
        // TODO: instead of a LONG test which is almost acceptance or not testing at all
        ArrayList<String> followers = followedRepository
                .getFollowedWithItself(line.split(" ")[0]);
        ArrayList<Message> wallMessages = messageRepository.getAllFrom(followers);
        messagePrinter.printMessagesWithAuthor(wallMessages);
    }

}
