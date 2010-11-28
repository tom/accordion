package net.tommalone.accordion.internal;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.AddACommand;
import net.tommalone.accordion.commands.WithAssertListener;
import org.concordion.api.Command;
import org.concordion.internal.listener.AssertResultRenderer;

public class AccordionAddACommand implements AddACommand {


    private final String nameSpace;
    private final AccordionBuilder accordionBuilder;
    private final AssertResultRenderer assertRenderer;

    public AccordionAddACommand(String nameSpace, AccordionBuilder accordionBuilder, AssertResultRenderer assertRenderer) {
        this.nameSpace = nameSpace;
        this.accordionBuilder = accordionBuilder;
        this.assertRenderer = assertRenderer;
    }

    @Override
    public AddACommand addCommand(String name, Command command) {
        accordionBuilder.addNameSpace(nameSpace, name, command);
        return this;
    }
}
