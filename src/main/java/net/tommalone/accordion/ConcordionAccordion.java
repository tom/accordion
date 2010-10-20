package net.tommalone.accordion;

import org.concordion.Concordion;
import org.concordion.api.*;

import java.io.IOException;

public class ConcordionAccordion implements Accordion {

    private Concordion concordion;

    public ConcordionAccordion(Concordion concordion) {
        this.concordion = concordion;
    }

    @Override
    public ResultSummary process(Object fixture) throws IOException {
        return concordion.process(fixture);
    }

    @Override
    public ResultSummary process(Resource resource, Object fixture) throws IOException {
        return concordion.process(resource, fixture);
    }

}
