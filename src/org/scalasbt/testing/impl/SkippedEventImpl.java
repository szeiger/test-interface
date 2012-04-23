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
     * @param fullyQualifiedName the fully qualified name of a class that can rerun the suite or test
     *                           about which an event was fired
     * @param isModule indicates whether the fullyQualifiedName refers to a module (singleton object). If so, the
     *          fullyQualifiedName parameter does not include the trailing dollar sign.
     * @param selector additional information identifying the suite or test about which an event was fired
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code> is null.
     */
    public SkippedEventImpl(String fullyQualifiedName, boolean isModule, Selector selector) {
        super(fullyQualifiedName, isModule, selector, null, EventType.Skipped);
    }
}
