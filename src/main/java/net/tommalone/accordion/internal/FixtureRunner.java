package net.tommalone.accordion.internal;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.integration.junit4.AccordionRunner;
import net.tommalone.accordion.ConcordionAccordionBuilder;
import org.concordion.api.FullOGNL;
import org.concordion.api.ResultSummary;
import org.concordion.internal.OgnlEvaluatorFactory;
import org.concordion.internal.listener.AssertResultRenderer;
import org.concordion.internal.listener.VerifyRowsResultRenderer;

import java.io.IOException;

public class FixtureRunner {

    public ResultSummary run(final Object fixture, WithAccordionBuilder withAccordionBuilder) throws IOException {
        AssertResultRenderer assertRenderer = new AssertResultRenderer();
        VerifyRowsResultRenderer verifyRowsResultRenderer = new VerifyRowsResultRenderer();
        AccordionBuilder accordionBuilder = new ConcordionAccordionBuilder(assertRenderer, verifyRowsResultRenderer);
        accordionBuilder.withAssertEqualsListener(assertRenderer);
        accordionBuilder.withAssertTrueListener(assertRenderer);
        accordionBuilder.withAssertFalseListener(assertRenderer);
        accordionBuilder.withVerifyRowsListener(verifyRowsResultRenderer);
        withAccordionBuilder.withAccordionBuilder(accordionBuilder);
        new WithCommandsExecuter(fixture).execute(accordionBuilder, assertRenderer);
        if (fixture.getClass().isAnnotationPresent(FullOGNL.class)) {
            accordionBuilder.withEvaluatorFactory(new OgnlEvaluatorFactory());
        }
        ResultSummary resultSummary = accordionBuilder.build().process(fixture);
        resultSummary.print(System.out, fixture);
        resultSummary.assertIsSatisfied(fixture);
        return resultSummary;
    }
}
