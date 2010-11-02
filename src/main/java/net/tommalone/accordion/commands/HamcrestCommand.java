package net.tommalone.accordion.commands;

import org.concordion.api.*;
import org.concordion.internal.util.Check;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

public abstract class HamcrestCommand extends BaseWithAssertListenerCommand {

    public abstract Matcher getMatcher(Object actual);

    @Override
    public void verify(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
        Check.isFalse(commandCall.hasChildCommands(), "Nesting commands inside an 'assertEquals' is not supported");

        Element element = commandCall.getElement();

        Object actual = evaluator.evaluate(commandCall.getExpression());
        String expected = element.getText();

        Matcher matcher = getMatcher(actual);
        if (matcher.matches(expected)) {
            resultRecorder.record(Result.SUCCESS);
            announceSuccess(element);
        } else {
            resultRecorder.record(Result.FAILURE);
            StringDescription description = new StringDescription();
            matcher.describeTo(description);
            announceFailure(element, expected, description.toString());
        }
    }


}
