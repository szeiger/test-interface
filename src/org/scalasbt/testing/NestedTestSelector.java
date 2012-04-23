package org.scalasbt.testing;

/**
 * Information in addition to a test class name that identifies a test in a nested suite about which an
 * event was fired.
 */
public interface NestedTestSelector extends Selector {

    /**
     * An id that, in addition to a test class name, identifies a nested suite that contains a test
     * about which an event was fired.
     *
     * @return the id of the nested suite containing the test
     */
    public String getSuiteId();

    /**
     * The name of the test in a nested suite about which an event was fired.
     *
     * @return the name of the test in the nested suite identified by the id returned by <code>getSuiteId</code>.
     */
    public String getTestName();

}
