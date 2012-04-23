package org.scalasbt.testing;

/**
 * Information in addition to a test class name that identifies a nested suite about which an
 * event was fired.
 */
public interface NestedSuiteSelector extends Selector {

    /**
     * An id that, in addition to a test class name, identifies a nested suite about which an
     * event was fired.
     *
     * @return the id of the nested suite
     */
    public String getSuiteId();
}
