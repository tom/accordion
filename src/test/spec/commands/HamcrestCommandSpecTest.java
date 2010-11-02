package commands;

import net.tommalone.accordion.AccordionRunner;
import net.tommalone.accordion.AddACommand;
import net.tommalone.accordion.WithCommands;
import net.tommalone.accordion.commands.HamcrestCommand;
import org.hamcrest.Matcher;
import org.hamcrest.text.StringContains;
import org.junit.runner.RunWith;

@RunWith(AccordionRunner.class)
public class HamcrestCommandSpecTest {

    public static final String TOM_NAMESPACE = "http://www.tommalone.net";

    @WithCommands(nameSpace = TOM_NAMESPACE)
    public AddACommand addAssertContainsCommand(AddACommand addACommand) {
        addACommand.addCommand("assertContains", new HamcrestCommand(){

            @Override
            public Matcher getMatcher(Object actual) {
                return StringContains.containsString((String) actual);
            }
        });
        return addACommand;
    }

}
