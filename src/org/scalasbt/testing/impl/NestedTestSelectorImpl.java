package org.scalasbt.testing.impl;

import org.scalasbt.testing.NestedTestSelector;

/**
 * Information in addition to a test class name that identifies a test in a nested suite about which an
 * event was fired.
 */
public class NestedTestSelectorImpl implements NestedTestSelector {

    private String suiteId;
    private String testName;

    /**
     * Constructs a new <code>NestedSuiteSelector</code> with given <code>suiteId</code> and <code>testName</code>.
     *
     * @param suiteId the id of the nested suite containing the test
     * @param testName the name of the test
     */
    public NestedTestSelectorImpl(String suiteId, String testName) {
        if (suiteId == null) {
            throw new NullPointerException("suiteId was null");
        }
        if (testName == null) {
            throw new NullPointerException("testName was null");
        }
        this.suiteId = suiteId;
        this.testName = testName;
    }

    public String getSuiteId() {
        return suiteId;
    }

    public String getTestName() {
        return testName;
    }

}
