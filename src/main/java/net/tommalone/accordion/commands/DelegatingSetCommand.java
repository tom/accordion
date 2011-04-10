package net.tommalone.accordion.commands;

import org.concordion.api.AbstractCommand;
import org.concordion.api.CommandCall;
import org.concordion.api.Evaluator;
import org.concordion.api.ResultRecorder;
import org.concordion.internal.command.SetCommand;
import org.concordion.internal.command.VerifyRowsCommand;

public class DelegatingSetCommand extends AbstractCommand {
    private SetCommand setCommand = new SetCommand();

    @Override
    public void execute(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
        setCommand.verify(commandCall, evaluator, resultRecorder);
    }

}
