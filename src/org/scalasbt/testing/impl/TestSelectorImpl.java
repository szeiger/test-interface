package org.scalasbt.testing.impl;

import org.scalasbt.testing.TestSelector;

/**
 * Information in addition to a test class name that identifies a test directly contained in the suite
 * whose class had the fully qualified name specified as the <code>fullyQualifiedName</code> attribute
 * passed to the event.
 */
public class TestSelectorImpl implements TestSelector {
    
    private String testName;

    /**
     * Constructs a new <code>TestSelector</code> with passed <code>testName</code>.
     *
     * @param testName the name of the test about which an event as fired.
     */
    public TestSelectorImpl(String testName) {
        if (testName == null) {
            throw new NullPointerException("testName was null");
        }
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }
}
