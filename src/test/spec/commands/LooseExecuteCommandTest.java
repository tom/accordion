package commands;

import net.tommalone.accordion.AccordionRunner;
import net.tommalone.accordion.AddACommand;
import net.tommalone.accordion.WithCommands;
import net.tommalone.accordion.commands.LooseExecuteCommand;
import org.junit.runner.RunWith;

@RunWith(AccordionRunner.class)
public class LooseExecuteCommandTest {
//    foo.bar.foobar

    public static final String TOM_NAMESPACE = "http://www.tommalone.net";

    @WithCommands(nameSpace = TOM_NAMESPACE)
    public AddACommand addLooseExecuteCommand(AddACommand addACommand) {
        addACommand.addCommand("looseExecute", new LooseExecuteCommand());
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
        public FooBar getFoobar() {
            return new FooBar();
        }
    }

    public class FooBar {

    }
}
