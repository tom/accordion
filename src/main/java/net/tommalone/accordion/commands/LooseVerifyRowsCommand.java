package net.tommalone.accordion.commands;

import net.tommalone.accordion.internal.LooseOgnlEvaluator;
import org.concordion.api.AbstractCommand;
import org.concordion.api.CommandCall;
import org.concordion.api.Evaluator;
import org.concordion.api.ResultRecorder;
import org.concordion.api.listener.AssertEqualsListener;
import org.concordion.api.listener.AssertListener;
import org.concordion.internal.command.AssertEqualsCommand;
import org.concordion.internal.command.VerifyRowsCommand;

public class LooseVerifyRowsCommand extends AbstractCommand {
    private VerifyRowsCommand verifyRowsCommand = new VerifyRowsCommand();

    @Override
    public void execute(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
        verifyRowsCommand.verify(commandCall, new LooseOgnlEvaluator(evaluator), resultRecorder);
    }

}
