package commands;

import net.tommalone.accordion.AddACommand;
import net.tommalone.accordion.WithCommands;
import net.tommalone.accordion.commands.LooseAssertTrueCommand;
import org.junit.runner.RunWith;

@RunWith(TestAccordionRunner.class)
public class LooseAssertTrueCommandTest {

    public static final String TOM_NAMESPACE = "http://www.tommalone.net";

    @WithCommands(nameSpace = TOM_NAMESPACE)
    public AddACommand addAssertContainsCommand(AddACommand addACommand) {
        addACommand.addCommand("looseAssertTrue", new LooseAssertTrueCommand());
        return addACommand;
    }

    public Foo getFoo() {
        return new Foo();
    }

    public class Foo {
        public Bar getBar() {
            return new Bar();
        }
    }

    public class Bar {
        public boolean getFoobar() {
            return true;
        }
    }

}
