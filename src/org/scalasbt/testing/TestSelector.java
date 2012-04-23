package org.scalasbt.testing;

/**
 * Information in addition to a test class name that identifies a test directly contained in the suite
 * whose class had the fully qualified name specified as the <code>fullyQualifiedName</code> attribute
 * passed to the event.
 */
public interface TestSelector extends Selector {
    
    /**
     * The name of a test about which an event was fired.
     *
     * @return the name of the test
     */
    public String getTestName();
}
