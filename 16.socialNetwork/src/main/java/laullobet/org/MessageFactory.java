package laullobet.org;

public class MessageFactory {


    public Message createMessage(String user, String message) {
        return  new Message(user,message,0);
    }
}
