package net.tommalone.accordion.commands;

import org.concordion.api.AbstractCommand;
import org.concordion.api.Element;
import org.concordion.api.listener.ExpressionEvaluatedEvent;
import org.concordion.api.listener.MissingRowEvent;
import org.concordion.api.listener.SurplusRowEvent;
import org.concordion.api.listener.VerifyRowsListener;
import org.concordion.internal.util.Announcer;

public class BaseWithVerifyRowsListenerCommand extends AbstractCommand implements WithVerifyRowsListener {

    private Announcer<VerifyRowsListener> listeners = Announcer.to(VerifyRowsListener.class);

    @Override
    public void addVerifyRowsListener(VerifyRowsListener listener) {
        listeners.addListener(listener);
    }

    @Override
    public void removeVerifyRowsListener(VerifyRowsListener listener) {
        listeners.removeListener(listener);
    }

    protected void announceExpressionEvaluated(Element element) {
        listeners.announce().expressionEvaluated(new ExpressionEvaluatedEvent(element));
    }

    protected void announceMissingRow(Element element) {
        listeners.announce().missingRow(new MissingRowEvent(element));
    }

    protected void announceSurplusRow(Element element) {
        listeners.announce().surplusRow(new SurplusRowEvent(element));
    }

}
