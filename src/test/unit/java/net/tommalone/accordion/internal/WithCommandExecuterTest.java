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

@RunWith(JMock.class)
public class WithCommandExecuterTest {

    private static final SetCommand A_COMMAND = new SetCommand();

    private Mockery context = new Mockery();

    @Test
    public void callsDownToAccordionBuilderWithCommandForMethodsWithAnnotation() {
        WithCommandExecuter withCommandExecuter = new WithCommandExecuter(new Foo());

        final AccordionBuilder accordionBuilder = context.mock(AccordionBuilder.class);

        context.checking(new Expectations(){{
            one(accordionBuilder).addNameSpace(with(equal("http://www.tom.com")), with(equal("malone")), with(same(A_COMMAND)));
        }});

        withCommandExecuter.execute(accordionBuilder);
    }

    class Foo {
        @WithCommand(nameSpace = "http://www.tom.com", name = "malone")
        public Command aCommand(){
            return A_COMMAND;
        }
    }

}
