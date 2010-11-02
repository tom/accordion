package net.tommalone.accordion.internal;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.AddACommand;
import net.tommalone.accordion.WithCommands;
import org.concordion.internal.command.SetCommand;
import org.concordion.internal.listener.AssertResultRenderer;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(JMock.class)
public class WithCommandsExecuterTest {

    private static final SetCommand A_COMMAND = new SetCommand();

    private Mockery context = new Mockery();

    @Test
    public void callsDownToAccordionBuilderWithCommandForMethodsWithAnnotation() {
        WithCommandsExecuter withCommandsExecuter = new WithCommandsExecuter(new ValidTest());

        final AccordionBuilder accordionBuilder = context.mock(AccordionBuilder.class);
        final AssertResultRenderer assertRenderer = new AssertResultRenderer();

        context.checking(new Expectations() {{
            one(accordionBuilder).addNameSpace(with(equal("http://www.tom.com")), with(equal("foo")), with(same(A_COMMAND)));
            one(accordionBuilder).addNameSpace(with(equal("http://www.tom.com")), with(equal("bar")), with(same(A_COMMAND)));
        }});

        withCommandsExecuter.execute(accordionBuilder, assertRenderer);
    }

    @Test
    public void doesntCallToAccordionBuilderIfNoAnnotations() {
        WithCommandsExecuter withCommandsExecuter = new WithCommandsExecuter(new ValidWIthNoAnnotations());

        final AccordionBuilder accordionBuilder = context.mock(AccordionBuilder.class);
        final AssertResultRenderer assertRenderer = new AssertResultRenderer();

        context.checking(new Expectations() {{
            never(accordionBuilder);
        }});

        withCommandsExecuter.execute(accordionBuilder, assertRenderer);
    }

    @Test
    public void throwsRunTimeExceptionIfNoInputParameter() {
        WithCommandsExecuter withCommandsExecuter = new WithCommandsExecuter(new InValidAsNoInputParameter());

        final AccordionBuilder accordionBuilder = context.mock(AccordionBuilder.class);
        final AssertResultRenderer assertRenderer = new AssertResultRenderer();

        context.checking(new Expectations() {{
            never(accordionBuilder);
        }});

        try {
            withCommandsExecuter.execute(accordionBuilder, assertRenderer);
            fail("No Add A Command Was added so should throw exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("You have not provided a method called aCommand that takes a AccordionAddACommand, now go away and add one")));
        }
    }


    class ValidTest {
        @WithCommands(nameSpace = "http://www.tom.com")
        public AddACommand aCommand(AddACommand addACommand) {
            addACommand.addCommand("foo", A_COMMAND);
            addACommand.addCommand("bar", A_COMMAND);
            return addACommand;
        }
    }

    public class InValidAsNoInputParameter {
        @WithCommands(nameSpace = "http://www.tom.com")
        public void aCommand() {

        }
    }

    public class ValidWIthNoAnnotations {
        public void foo() {

        }

        public void fooBar() {

        }
    }

}
