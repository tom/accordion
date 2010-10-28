package net.tommalone.accordion;

import org.concordion.api.Command;
import org.concordion.api.listener.ThrowableCaughtListener;

public interface AccordionBuilder {

    AccordionBuilder addNameSpace(String nameSpace, String commandName, Command command);

    AccordionBuilder addThrowableCaughtListener(ThrowableCaughtListener throwableCaughtListener);

    Accordion build();

}
