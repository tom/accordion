package net.tommalone.accordion.commands;

import org.concordion.api.listener.AssertListener;

public interface WithAssertListener {
    
    void addAssertListener(AssertListener listener);

    void removeAssertListener(AssertListener listener);
}
