package org.scalasbt.testing;

/**
 * Information in addition to a test class name that identifies the suite or test about which an
 * event was fired.
 *
 * <p>
 * Selector subclasses should implement the <code>hashCode/</code> and <code>equals</code> methods
 * properly to get the desired equality semantics. The name of a selector is only used for displaying
 * it to the user but never for comparing selectors.
 * </p> 
 */
public interface Selector {
  /**
   * The name to display for this selector. This is usually a hierarchical name of the form
   * <code>suite.method</code> or <code>suite.nestedSuite.method</code>. For top-level suites,
   * the name must be the fully qualified class name (without the trailing dollar sign in case
   * of an object).
   */
  public String getDisplayName();

  /**
   * The parent of this selector, or <code>null</code> if this selector refers to a test class
   * (the top level of the selector hierarchy).
   */
  public Selector getParent();

  /**
   * The type of this selector (a test method or a class- or object-based suite).
   */
  public SelectorType getSelectorType();
}
