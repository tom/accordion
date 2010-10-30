package net.tommalone.accordion.internal;

import net.tommalone.accordion.AccordionBuilder;
import org.concordion.api.Command;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class AccordionAddACommandTest {

    private final Mockery context = new Mockery();
    
    @Test
    public void callDownToCommandWithName() {

        final AccordionBuilder accordionBuilder = context.mock(AccordionBuilder.class);
        final Command aCommand = context.mock(Command.class);

        context.checking(new Expectations(){{
            atLeast(1).of(accordionBuilder).addNameSpace("http://namespace.com", "foo", aCommand);
        }});

        new AccordionAddACommand("http://namespace.com", accordionBuilder).addCommand("foo", aCommand);

    }

}
