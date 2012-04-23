package org.scalasbt.testing;

/**
 * An Event fired by the test framework during a run.
 */
public interface Event {

    /**
     * The fully qualified test class name about which an event was fired.
     *
     * @return the fully qualified test class name
     */
    public String getFullyQualifiedName();

    /**
     * Indicates whether the fullyQualifiedName refers to a module (singleton object). If so, the
     *          fullyQualifiedName parameter does not include the trailing dollar sign.
     *
     * @return true if the fullyQualifiedName refers to a module instead of a class
     */
    public boolean isModule();

    /**
     * A <code>Selector</code> that can be used to identify the suite or test about which an event was fired.
     *
     * @return the fully qualified test class name
     */
    public Selector getSelector();

    /**
     * The type of the event which was fired.
     *
     * @return the type of the event.
     */
    public EventType getEventType();

    /**
     * Returns the <code>Throwable</code> that caused this <code>Event</code>, or
     *          <code>null</code> if no <code>Throwable</code> was associated with this event.
     *          Test frameworks should always return <code>null</code> for event types
     *          <code>Skipped</code> and <code>Success</code>.
     *
     * @return the <code>Throwable</code> for this <code>Event</code>.
     */
    public Throwable getCause();
}
