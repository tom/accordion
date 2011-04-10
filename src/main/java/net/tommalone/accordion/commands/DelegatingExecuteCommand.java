package net.tommalone.accordion.commands;

import org.concordion.api.AbstractCommand;
import org.concordion.api.CommandCall;
import org.concordion.api.Evaluator;
import org.concordion.api.ResultRecorder;
import org.concordion.internal.command.ExecuteCommand;

public class DelegatingExecuteCommand extends AbstractCommand {
    private ExecuteCommand executeCommand = new ExecuteCommand();

    @Override
    public void execute(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
        executeCommand.execute(commandCall, evaluator, resultRecorder);
    }
}
