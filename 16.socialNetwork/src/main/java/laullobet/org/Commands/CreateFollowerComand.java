package laullobet.org.Commands;

import laullobet.org.Commands.Command;
import laullobet.org.Commands.CommandLineValue;
import laullobet.org.FollowedRepository;

public class CreateFollowerComand extends Command {
    private final FollowedRepository followedRepository;

    public CreateFollowerComand(CommandLineValue line, FollowedRepository followedRepository) {
        super(line);
        this.followedRepository = followedRepository;
    }

    @Override
    public void execute(){
        followedRepository.add(line.firstArg(),line.thirdArg());
    }
}
