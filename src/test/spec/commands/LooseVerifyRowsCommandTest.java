package commands;

import net.tommalone.accordion.AddACommand;
import net.tommalone.accordion.WithCommands;
import net.tommalone.accordion.commands.LooseAssertTrueCommand;
import net.tommalone.accordion.commands.LooseVerifyRowsCommand;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(TestAccordionRunner.class)
public class LooseVerifyRowsCommandTest {

    public static final String TOM_NAMESPACE = "http://www.tommalone.net";

    @WithCommands(nameSpace = TOM_NAMESPACE)
    public AddACommand addAssertContainsCommand(AddACommand addACommand) {
        addACommand.addCommand("looseVerifyRows", new LooseVerifyRowsCommand());
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
        public List<String> getFoobar() {
            List<String> names = new ArrayList<String>();
            names.add("Tom");
            names.add("Joe");
            names.add("Mike");
            return names;
        }
    }

}
