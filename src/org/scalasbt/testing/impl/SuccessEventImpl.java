package org.scalasbt.testing.impl;

import org.scalasbt.testing.EventType;
import org.scalasbt.testing.Selector;

/**
 * Default implementation of a <code>SuccessEvent</code>.
 */
public class SuccessEventImpl extends EventImpl {

    /**
     * Constructs a new <code>SuccessEvent</code> with passed fully qualified name, isModule flag, and selector.
     *
     * @param selector additional information identifying the suite or test about which an event was fired
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code> is null.
     */
    public SuccessEventImpl(Selector selector) {
        super(selector, null, EventType.Success);
    }
}
