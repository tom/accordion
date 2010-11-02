package net.tommalone.accordion;

import org.concordion.api.Command;
import org.concordion.api.listener.ThrowableCaughtListener;
import org.concordion.internal.ConcordionBuilder;
import org.concordion.internal.OgnlEvaluatorFactory;
import org.concordion.internal.listener.AssertResultRenderer;

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

    @Override
    public void withEvaluatorFactory(OgnlEvaluatorFactory ognlEvaluatorFactory) {
        concordionBuilder.withEvaluatorFactory(ognlEvaluatorFactory);
    }

    @Override
    public void withAssertEqualsListener(AssertResultRenderer assertRenderer) {
        concordionBuilder.withAssertEqualsListener(assertRenderer);
    }

    @Override
    public void withAssertTrueListener(AssertResultRenderer assertRenderer) {
        concordionBuilder.withAssertTrueListener(assertRenderer);
    }

    @Override
    public void withAssertFalseListener(AssertResultRenderer assertRenderer) {
        concordionBuilder.withAssertFalseListener(assertRenderer);
    }


}
