package org.scalasbt.testing.impl;

import org.scalasbt.testing.EventType;
import org.scalasbt.testing.Selector;

/**
 * Default implementation of a <code>FailureEvent</code>.
 */
public class FailureEventImpl extends EventImpl {

    /**
     * Constructs a new <code>FailureEvent</code> with passed fully qualified name, isModule flag, selector,
     * and <code>Throwable</code>.
     *
     * <p>
     * The passed <code>Throwable</code> may not be null. If you wish to indicate no <code>Throwable</code> is
     * associated with this event, you must use the other constructor.
     * </p>
     *
     *
     * @param selector additional information identifying the suite or test about which an event was fired
     * @param cause a <code>Throwable</code> associated with this <code>FailureEvent</code>,
     *              or <code>null</code> if no <code>Throwable</code> is associated with this event.
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code>is null.
     */
    public FailureEventImpl(Selector selector, Throwable cause) {
        super(selector, cause, EventType.Failure);
    }

    /**
     * Constructs a new <code>FailureEvent</code> with passed fully qualified name, isModule flag, selector,
     * and a <code>null</code> <code>Throwable</code>.
     *
     *
     * @param selector additional information identifying the suite or test about which an event was fired
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code>is null.
     */
    public FailureEventImpl(Selector selector) {
        super(selector, null, EventType.Failure);
    }
}
