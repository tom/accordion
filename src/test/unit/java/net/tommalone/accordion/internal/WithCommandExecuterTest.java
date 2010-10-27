package net.tommalone.accordion.internal;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.WithCommand;
import org.concordion.api.Command;
import org.concordion.internal.command.SetCommand;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.internal.InvocationExpectation;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(JMock.class)
public class WithCommandExecuterTest {

    private static final SetCommand A_COMMAND = new SetCommand();

    private Mockery context = new Mockery();

    @Test
    public void callsDownToAccordionBuilderWithCommandForMethodsWithAnnotation() {
        WithCommandExecuter withCommandExecuter = new WithCommandExecuter(new Foo());

        final AccordionBuilder accordionBuilder = context.mock(AccordionBuilder.class);

        context.checking(new Expectations() {{
            one(accordionBuilder).addNameSpace(with(equal("http://www.tom.com")), with(equal("malone")), with(same(A_COMMAND)));
        }});

        withCommandExecuter.execute(accordionBuilder);
    }

    @Test
    public void throwIllegalArgumentExceptionIfACommandIsNotReturned() {
        WithCommandExecuter withCommandExecuter = new WithCommandExecuter(new Bar());

        final AccordionBuilder accordionBuilder = context.mock(AccordionBuilder.class);

        context.checking(new Expectations() {{
            never(accordionBuilder).addNameSpace(with(any(String.class)), with(any(String.class)), with(any(Command.class)));
        }});

        try {
            withCommandExecuter.execute(accordionBuilder);
            fail("method does not return a command should throw IllegalStateException");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage(), is(equalTo("A String was returned a Command is the required return type of a method with @WithCommand annotation")));
        }
    }

    class Foo {
        @WithCommand(nameSpace = "http://www.tom.com", name = "malone")
        public Command aCommand() {
            return A_COMMAND;
        }
    }

    class Bar {
        @WithCommand(nameSpace = "http://www.tom.com", name = "malone")
        public String aCommand() {
            return "Some Command";
        }
    }

}
