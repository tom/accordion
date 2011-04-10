package net.tommalone.accordion.commands;

import org.concordion.api.AbstractCommand;
import org.concordion.api.CommandCall;
import org.concordion.api.Evaluator;
import org.concordion.api.ResultRecorder;
import org.concordion.api.listener.AssertEqualsListener;
import org.concordion.api.listener.AssertListener;
import org.concordion.internal.command.AssertEqualsCommand;

public class DelegatingAssertEqualsCommand extends AbstractCommand implements WithAssertListener {
    private AssertEqualsCommand assertEqualCommand = new AssertEqualsCommand();

    @Override
    public void execute(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
        assertEqualCommand.verify(commandCall, evaluator, resultRecorder);
    }

    @Override
    public void addAssertListener(AssertListener listener) {
        assertEqualCommand.addAssertEqualsListener((AssertEqualsListener) listener);
    }

    @Override
    public void removeAssertListener(AssertListener listener) {
        assertEqualCommand.removeAssertEqualsListener((AssertEqualsListener) listener);
    }
}
