package net.tommalone.accordion;

import org.concordion.api.Command;
import org.concordion.internal.command.ThrowableCaughtListener;

public interface AccordionBuilder {

    AccordionBuilder addNameSpace(String nameSpace, String commandName, Command command);

    AccordionBuilder addThrowableCaughtListener(ThrowableCaughtListener throwableCaughtListener);

    Accordion build();

}
