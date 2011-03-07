package integration.junit3;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.AddACommand;
import net.tommalone.accordion.WithCommands;
import net.tommalone.accordion.commands.HamcrestCommand;
import net.tommalone.accordion.integration.junit3.AbstractAccordionTestCase;
import org.hamcrest.Matcher;
import org.hamcrest.text.StringContains;

public class Junit3WithOutAnnotationTest extends AbstractAccordionTestCase {

    public static final String TOM_NAMESPACE = "http://www.tommalone.net";

    @Override
    public void withAccordionBuilder(AccordionBuilder accordionBuilder) {
        accordionBuilder.addNameSpace(TOM_NAMESPACE, "assertContains", new HamcrestCommand(){

            @Override
            public Matcher getMatcher(Object actual) {
                return StringContains.containsString((String) actual);
            }
        });
    }
}