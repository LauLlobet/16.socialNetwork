package laullobet.org;

public class TimeAgoMessageFormatter implements MessageFormatter {
    private final Clock clock;

    public TimeAgoMessageFormatter(Clock clock) {

        this.clock = clock;
    }

    public String format(Message message) {
        throw new UnsupportedOperationException();
    }
}
