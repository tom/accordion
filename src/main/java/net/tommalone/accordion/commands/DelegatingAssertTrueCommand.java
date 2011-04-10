package net.tommalone.accordion.commands;

import net.tommalone.accordion.internal.LooseOgnlEvaluator;
import org.concordion.api.AbstractCommand;
import org.concordion.api.CommandCall;
import org.concordion.api.Evaluator;
import org.concordion.api.ResultRecorder;
import org.concordion.api.listener.AssertListener;
import org.concordion.internal.command.AssertTrueCommand;

public class DelegatingAssertTrueCommand extends AbstractCommand implements WithAssertListener{
    private AssertTrueCommand assertTrueCommand = new AssertTrueCommand();

    @Override
    public void execute(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
        assertTrueCommand.verify(commandCall, evaluator, resultRecorder);
    }

    @Override
    public void addAssertListener(AssertListener listener) {
        assertTrueCommand.addAssertListener(listener);
    }

    @Override
    public void removeAssertListener(AssertListener listener) {
        assertTrueCommand.removeAssertListener(listener);
    }
}
