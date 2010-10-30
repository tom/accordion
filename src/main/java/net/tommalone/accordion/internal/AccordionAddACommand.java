package net.tommalone.accordion.internal;

import net.tommalone.accordion.AccordionBuilder;
import net.tommalone.accordion.AddACommand;
import org.concordion.api.Command;

public class AccordionAddACommand implements AddACommand {


    private final String nameSpace;
    private final AccordionBuilder accordionBuilder;

    public AccordionAddACommand(String nameSpace, AccordionBuilder accordionBuilder) {

        this.nameSpace = nameSpace;
        this.accordionBuilder = accordionBuilder;
    }

    @Override
    public AddACommand addCommand(String name, Command command) {
        accordionBuilder.addNameSpace(nameSpace, name, command);
        return this;
    }
}
