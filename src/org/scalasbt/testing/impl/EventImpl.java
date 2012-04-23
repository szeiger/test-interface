package org.scalasbt.testing.impl;

import org.scalasbt.testing.Event;
import org.scalasbt.testing.EventType;
import org.scalasbt.testing.Selector;

/**
 * Default implementation of an <code>Event</code>.
 */
public abstract class EventImpl implements Event {

    private String fullyQualifiedName;
    private boolean isModule;
    private Selector selector;
    private Throwable cause;
    private EventType eventType;

    /**
     * Constructs a new <code>Event</code> with passed fully qualified name, isModule flag, and selector.
     *
     * @param fullyQualifiedName the fully qualified name of a class that can rerun the suite or test
     *                           about which an event was fired
     * @param isModule indicates whether the fullyQualifiedName refers to a module (singleton object). If so, the
     *          fullyQualifiedName parameter does not include the trailing dollar sign.
     * @param selector additional information identifying the suite or test about which an event was fired
     * @param cause a <code>Throwable</code> associated with this <code>Event</code>,
     *              or <code>null</code> if no <code>Throwable</code> is associated with this event.
     * @param eventType the type of event this object represents.
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code> is null.
     */
    public EventImpl(String fullyQualifiedName, boolean isModule, Selector selector, Throwable cause, EventType eventType) {
        if (fullyQualifiedName == null) {
            throw new NullPointerException("fullyQualifiedName was null");
        }
        if (selector == null) {
            throw new NullPointerException("selector was null");
        }
        this.fullyQualifiedName = fullyQualifiedName;
        this.isModule = isModule;
        this.selector = selector;
        this.cause = cause;
        this.eventType = eventType;
    }

    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    public boolean isModule() {
        return isModule;
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
