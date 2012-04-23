package org.scalasbt.testing.impl;

import org.scalasbt.testing.EventType;
import org.scalasbt.testing.Selector;

/**
 * Default implementation of a <code>SkippedEvent</code>.
 */
public class SkippedEventImpl extends EventImpl {

    /**
     * Constructs a new <code>SkippedEvent</code> with passed fully qualified name, isModule flag, and selector.
     *
     * @param selector additional information identifying the suite or test about which an event was fired
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code> is null.
     */
    public SkippedEventImpl(Selector selector) {
        super(selector, null, EventType.Skipped);
    }
}
