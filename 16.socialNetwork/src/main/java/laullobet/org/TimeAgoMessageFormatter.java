package laullobet.org;

public class TimeAgoMessageFormatter implements MessageFormatter {
    private final Clock clock;

    public TimeAgoMessageFormatter(Clock clock) {

        this.clock = clock;
    }

    public String format(Message message) {
        return message.getMessageBody()+" ("
                + getTimeAgoString(message.getTimestamp())
                + " ago)";
    }

    private String getTimeAgoString(int timestamp) {
        int elapsedSeconds = elapsedMillis(timestamp)/1000;

        if(elapsedSeconds < 60){
            return elapsedSeconds + " seconds";
        }
        return (elapsedSeconds)/60 +" minutes";
    }

    private int elapsedMillis(int messageMillis) {
        return clock.getCurrentTimeMillis() - messageMillis;
    }
}
