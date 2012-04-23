package org.scalasbt.testing.impl;

import org.scalasbt.testing.NestedSuiteSelector;

/**
 * Information in addition to a test class name that identifies a nested suite about which an
 * event was fired.
 */
public class NestedSuiteSelectorImpl implements NestedSuiteSelector {

    private String suiteId;

    public NestedSuiteSelectorImpl(String suiteId) {
        if (suiteId == null) {
            throw new NullPointerException("suiteId was null");
        }
        this.suiteId = suiteId;
    }

    public String getSuiteId() {
        return suiteId;
    }

    public String getDisplayName() {
        return suiteId;
    }
}
