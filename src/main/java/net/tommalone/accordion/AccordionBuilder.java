package net.tommalone.accordion;

import org.concordion.api.Command;
import org.concordion.api.listener.ThrowableCaughtListener;
import org.concordion.internal.OgnlEvaluatorFactory;
import org.concordion.internal.listener.AssertResultRenderer;

public interface AccordionBuilder {

    AccordionBuilder addNameSpace(String nameSpace, String commandName, Command command);

    AccordionBuilder addThrowableCaughtListener(ThrowableCaughtListener throwableCaughtListener);

    Accordion build();

    void withEvaluatorFactory(OgnlEvaluatorFactory ognlEvaluatorFactory);

    void withAssertEqualsListener(AssertResultRenderer assertRenderer);

    void withAssertTrueListener(AssertResultRenderer assertRenderer);

    void withAssertFalseListener(AssertResultRenderer assertRenderer);
}
