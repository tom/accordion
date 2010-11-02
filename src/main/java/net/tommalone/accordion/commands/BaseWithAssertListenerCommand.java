package net.tommalone.accordion.commands;

import org.concordion.api.AbstractCommand;
import org.concordion.api.Element;
import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertListener;
import org.concordion.api.listener.AssertSuccessEvent;
import org.concordion.internal.util.Announcer;

public class BaseWithAssertListenerCommand extends AbstractCommand implements WithAssertListener {

    private Announcer<AssertListener> listeners = Announcer.to(AssertListener.class);

    @Override
    public void addAssertListener(AssertListener listener) {
        listeners.addListener(listener);
    }

    @Override
    public void removeAssertListener(AssertListener listener) {
        listeners.removeListener(listener);
    }

    protected void announceSuccess(Element element) {
        listeners.announce().successReported(new AssertSuccessEvent(element));
    }

    protected void announceFailure(Element element, String expected, Object actual) {
        listeners.announce().failureReported(new AssertFailureEvent(element, expected, actual));
    }
}
