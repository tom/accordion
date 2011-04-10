package net.tommalone.accordion.commands;

import net.tommalone.accordion.internal.LooseOgnlEvaluator;
import org.concordion.api.AbstractCommand;
import org.concordion.api.CommandCall;
import org.concordion.api.Evaluator;
import org.concordion.api.ResultRecorder;
import org.concordion.internal.command.SetCommand;

public class LooseSetCommand extends AbstractCommand {
    private SetCommand setCommand = new SetCommand();

    @Override
    public void execute(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
        setCommand.verify(commandCall, new LooseOgnlEvaluator(evaluator), resultRecorder);
    }

}
