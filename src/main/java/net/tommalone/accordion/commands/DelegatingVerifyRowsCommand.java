package net.tommalone.accordion.commands;

import org.concordion.api.AbstractCommand;
import org.concordion.api.CommandCall;
import org.concordion.api.Evaluator;
import org.concordion.api.ResultRecorder;
import org.concordion.internal.command.VerifyRowsCommand;

public class DelegatingVerifyRowsCommand extends AbstractCommand {
    private VerifyRowsCommand verifyRowsCommand = new VerifyRowsCommand();

    @Override
    public void execute(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
        verifyRowsCommand.verify(commandCall, evaluator, resultRecorder);
    }

}
