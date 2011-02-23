package net.tommalone.accordion.commands;

import org.concordion.api.listener.VerifyRowsListener;

public interface WithVerifyRowsListener {

    void addVerifyRowsListener(VerifyRowsListener listener);

    void removeVerifyRowsListener(VerifyRowsListener listener);
}
