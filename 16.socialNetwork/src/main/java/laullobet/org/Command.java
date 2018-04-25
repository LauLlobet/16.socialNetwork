package laullobet.org;

public abstract class Command {

    protected final String line;

    Command(String line){

        this.line = line;
    }

    void execute(){
    }
}
