package net.tommalone.accordion;

import org.concordion.api.Resource;
import org.concordion.api.ResultSummary;

import java.io.IOException;

public interface Accordion {

    ResultSummary process(Object fixture) throws IOException;
    ResultSummary process(Resource resource, Object fixture) throws IOException;
    
}
