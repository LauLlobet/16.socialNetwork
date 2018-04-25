package laullobet.org;

public class AuthorAndTimeAgoMessageFormatter extends TimeAgoMessageFormatter{
    public AuthorAndTimeAgoMessageFormatter(Clock clock) {
        super(clock);
    }

    @Override
    public String   format(Message message){
        return message.getUser()+" - "+super.format(message);
    }
}
