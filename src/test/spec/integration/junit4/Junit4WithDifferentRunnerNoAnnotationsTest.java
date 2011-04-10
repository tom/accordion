package integration.junit4;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.commands.HamcrestCommand;
import net.tommalone.accordion.integration.junit4.BaseAccordionJunit4TestCase;
import org.hamcrest.Matcher;
import org.hamcrest.text.StringContains;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Junit4WithDifferentRunnerNoAnnotationsTest extends BaseAccordionJunit4TestCase {

    public static final String TOM_NAMESPACE = "http://www.tommalone.net";

    @Override
    public void withAccordionBuilder(AccordionBuilder accordionBuilder) {
        accordionBuilder.addNameSpace(TOM_NAMESPACE, "assertContains", new HamcrestCommand() {

            @Override
            public Matcher getMatcher(Object actual) {
                return StringContains.containsString((String) actual);
            }
        });
    }

}