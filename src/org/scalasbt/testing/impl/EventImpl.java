package org.scalasbt.testing.impl;

import org.scalasbt.testing.Event;
import org.scalasbt.testing.EventType;
import org.scalasbt.testing.Selector;

/**
 * Default implementation of an <code>Event</code>.
 */
public abstract class EventImpl implements Event {

    private Selector selector;
    private Throwable cause;
    private EventType eventType;

    /**
     * Constructs a new <code>Event</code> with passed fully qualified name, isModule flag, and selector.
     *
     * @param selector additional information identifying the suite or test about which an event was fired
     * @param cause a <code>Throwable</code> associated with this <code>Event</code>,
     *              or <code>null</code> if no <code>Throwable</code> is associated with this event.
     * @param eventType the type of event this object represents.
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code> is null.
     */
    public EventImpl(Selector selector, Throwable cause, EventType eventType) {
        if (selector == null) {
            throw new NullPointerException("selector was null");
        }
        this.selector = selector;
        this.cause = cause;
        this.eventType = eventType;
    }

    public Selector getSelector() {
        return selector;
    }

    public Throwable getCause() {
        return cause;
    }

    public EventType getEventType() {
        return eventType;
    }
}
