package net.tommalone.accordion.integration.junit4;


import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.internal.FixtureRunner;
import net.tommalone.accordion.internal.WithAccordionBuilder;
import org.junit.Test;

public class BaseAccordionJunit4Test implements WithAccordionBuilder {

    @Override
    public void withAccordionBuilder(AccordionBuilder accordionBuilder) {
    }

    @Test
    public void processSpecification() throws Throwable {
        new FixtureRunner().run(this, this);
    }
}
