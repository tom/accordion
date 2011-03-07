package net.tommalone.accordion.integration.junit3;

import junit.framework.TestCase;
import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.internal.FixtureRunner;
import net.tommalone.accordion.internal.WithAccordionBuilder;

public abstract class AbstractAccordionTestCase extends TestCase implements WithAccordionBuilder {

    @Override
    public void withAccordionBuilder(AccordionBuilder accordionBuilder) {

    }

    public void testProcessSpecification() throws Throwable {
        new FixtureRunner().run(this, this);
    }

}
