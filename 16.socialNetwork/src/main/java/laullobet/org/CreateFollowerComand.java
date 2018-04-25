package laullobet.org;

public class CreateFollowerComand extends Command {
    private final FollowedRepository followedRepository;

    public CreateFollowerComand(String line, FollowedRepository followedRepository) {
        super(line);
        this.followedRepository = followedRepository;
    }

    @Override
    public void execute(){
        String[] lineargs = line.split(" ");
        followedRepository.add(lineargs[0],lineargs[2]);
    }
}
