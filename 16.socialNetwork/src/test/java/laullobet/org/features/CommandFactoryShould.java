package laullobet.org.features;

import laullobet.org.Commands.Command;
import laullobet.org.Commands.CommandFactory;
import laullobet.org.Commands.CreateFollowerComand;
import org.junit.Test;

import javax.xml.stream.FactoryConfigurationError;

import static junit.framework.TestCase.assertTrue;

public class CommandFactoryShould {

    @Test
    public void
    should_convert_line_with_follows_to_follow_instruction() {
        //TODO: how you test a factory/command without talking about implementation
        CommandFactory comandFactory = new CommandFactory(null,null,
                null,null,null);

        Command command = comandFactory.createCommand("Bob follows Alice");
        assertTrue(command instanceof CreateFollowerComand);
    }
}
