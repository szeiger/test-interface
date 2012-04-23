package org.scalasbt.testing;

public enum SelectorType
{
  /**
   * A single test.
    */
  Leaf,

  /**
   * A top-level or nested test class.
   */
  Class,

  /**
   * A top-level or nested test object.
   */
  Object,

  /**
   * A (possibly nested) group of tests which does not map to a class or an object.
   */
  Group
}
