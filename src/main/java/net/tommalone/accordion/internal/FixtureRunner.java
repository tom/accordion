package net.tommalone.accordion.internal;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.AccordionRunner;
import net.tommalone.accordion.ConcordionAccordionBuilder;
import org.concordion.api.FullOGNL;
import org.concordion.api.ResultSummary;
import org.concordion.internal.ConcordionBuilder;
import org.concordion.internal.OgnlEvaluatorFactory;
import org.concordion.internal.listener.AssertResultRenderer;

import java.io.IOException;

public class FixtureRunner {

    public ResultSummary run(final Object fixture, AccordionRunner accordionRunner) throws IOException {
        AccordionBuilder accordionBuilder = new ConcordionAccordionBuilder();
        AssertResultRenderer assertRenderer = new AssertResultRenderer();
        accordionBuilder.withAssertEqualsListener(assertRenderer);
        accordionBuilder.withAssertTrueListener(assertRenderer);
        accordionBuilder.withAssertFalseListener(assertRenderer);
        accordionRunner.withAccordionBuilder(accordionBuilder);
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
