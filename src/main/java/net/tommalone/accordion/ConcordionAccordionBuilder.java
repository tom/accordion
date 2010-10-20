package net.tommalone.accordion;

import org.concordion.api.Command;
import org.concordion.internal.ConcordionBuilder;
import org.concordion.internal.command.ThrowableCaughtListener;

public class ConcordionAccordionBuilder implements AccordionBuilder {

    private ConcordionBuilder concordionBuilder = new ConcordionBuilder();

    @Override
    public ConcordionAccordionBuilder addNameSpace(String nameSpace, String commandName, Command command) {
        concordionBuilder.withCommand(nameSpace, commandName, command);
        return this;
    }

    @Override
    public AccordionBuilder addThrowableCaughtListener(ThrowableCaughtListener throwableCaughtListener) {
        concordionBuilder.withThrowableListener(throwableCaughtListener);
        return this;
    }

    @Override
    public Accordion build() {
        return new ConcordionAccordion(concordionBuilder.build());
    }


}
