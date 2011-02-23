package net.tommalone.accordion;

import net.tommalone.accordion.commands.WithAssertListener;
import net.tommalone.accordion.commands.WithVerifyRowsListener;
import org.concordion.api.Command;
import org.concordion.api.listener.ThrowableCaughtListener;
import org.concordion.internal.ConcordionBuilder;
import org.concordion.internal.OgnlEvaluatorFactory;
import org.concordion.internal.listener.AssertResultRenderer;
import org.concordion.internal.listener.VerifyRowsResultRenderer;

public class ConcordionAccordionBuilder implements AccordionBuilder {

    private ConcordionBuilder concordionBuilder = new ConcordionBuilder();
    private final AssertResultRenderer assertRenderer;
    private final VerifyRowsResultRenderer verifyRowsResultRenderer;

    public ConcordionAccordionBuilder(AssertResultRenderer assertRenderer, VerifyRowsResultRenderer verifyRowsResultRenderer) {
        this.assertRenderer = assertRenderer;
        this.verifyRowsResultRenderer = verifyRowsResultRenderer;
    }

    @Override
    public ConcordionAccordionBuilder addNameSpace(String nameSpace, String commandName, Command command) {
        concordionBuilder.withCommand(nameSpace, commandName, command);
        if (command instanceof WithAssertListener) {
            WithAssertListener withAssertListener = (WithAssertListener) command;
            withAssertListener.addAssertListener(assertRenderer);
        }
        if (command instanceof WithVerifyRowsListener) {
            WithVerifyRowsListener withVerifyRowsListener = (WithVerifyRowsListener) command;
            withVerifyRowsListener.addVerifyRowsListener(verifyRowsResultRenderer);
        }

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

    @Override
    public void withVerifyRowsListener(VerifyRowsResultRenderer assertRenderer) {
        concordionBuilder.withVerifyRowsListener(assertRenderer);
    }


}
