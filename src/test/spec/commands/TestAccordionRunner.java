package commands;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.AccordionRunner;
import net.tommalone.accordion.commands.LooseAssertEqualsCommand;
import net.tommalone.accordion.commands.LooseExecuteCommand;
import org.junit.runners.model.InitializationError;

public class TestAccordionRunner extends AccordionRunner {

    public static final String TOM_NAMESPACE = "http://www.tommalone.net";

    public TestAccordionRunner(Class<?> fixtureClass) throws InitializationError {
        super(fixtureClass);
    }

    @Override
    public void withAccordionBuilder(AccordionBuilder accordionBuilder) {
        accordionBuilder.addNameSpace(TOM_NAMESPACE, "looseExecute", new LooseExecuteCommand());
        accordionBuilder.addNameSpace(TOM_NAMESPACE, "looseAssertEquals", new LooseAssertEqualsCommand());
    }
}
