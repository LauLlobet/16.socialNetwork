package laullobet.org;

public class SocialNetwork {
    private final CommandFactory commandFactory;
    private final Console console;

    SocialNetwork(CommandFactory commandFactory, Console console) {
        this.commandFactory = commandFactory;
        this.console = console;
    }

    public void run() {
        String line = console.readLine();
        Command command = commandFactory.createCommand(line);
        command.execute();
    }





}
