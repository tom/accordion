package net.tommalone.accordion.internal;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.WithCommands;
import org.concordion.api.Command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WithCommandsExecuter {
    private final Object test;

    public WithCommandsExecuter(Object test) {
        this.test = test;
    }

    public void execute(AccordionBuilder accordionBuilder) {
        for (Method method : test.getClass().getMethods()) {
            if (method.isAnnotationPresent(WithCommands.class)) {
                try {
                    WithCommands withCommands = method.getAnnotation(WithCommands.class);

                    method.invoke(test, new Object[]{new AccordionAddACommand(withCommands.nameSpace(), accordionBuilder)});

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(String.format("You have not provided a method called %s that takes a AccordionAddACommand, now go away and add one", method.getName()));
                }
            }
        }
    }
}
