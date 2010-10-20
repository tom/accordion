package net.tommalone.accordion.internal;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.WithCommand;
import org.concordion.api.Command;
import org.concordion.internal.ConcordionBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WithCommandExecuter {
    private final Object test;

    public WithCommandExecuter(Object test) {
        this.test = test;
    }

    public void execute(AccordionBuilder accordionBuilder) {
        for (Method method : test.getClass().getMethods()) {
            if(method.isAnnotationPresent(WithCommand.class)) {
                try {
                    WithCommand withCommand = method.getAnnotation(WithCommand.class);
                    accordionBuilder.addNameSpace(withCommand.nameSpace(), withCommand.name(), (Command) method.invoke(test));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (InvocationTargetException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }
}
