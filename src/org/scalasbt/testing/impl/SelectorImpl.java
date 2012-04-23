package org.scalasbt.testing.impl;

import org.scalasbt.testing.Selector;
import org.scalasbt.testing.SelectorType;

/**
 * Default implementation of <code>Selector</code>.
 * 
 * Display names are constructed as a dot-separated hierarchy and equality
 * is defined by the display name plus selector type.
 */
public class SelectorImpl implements Selector {

  private final Selector parent;
  private final SelectorType selectorType;
  private final String localName;
  private String cachedDisplayName;

  public SelectorImpl(Selector parent, SelectorType selectorType, String localName) {
    if(parent != null && parent.getSelectorType() == SelectorType.Leaf)
      throw new IllegalArgumentException("Parent selector must be a suite");
    this.selectorType = selectorType;
    this.parent = parent;
    this.localName = localName;
  }

  public SelectorImpl(String fullyQualifiedClassName, boolean module) {
    this(null, module ? SelectorType.Object : SelectorType.Class, fullyQualifiedClassName);
  }

  @Override
  public synchronized String getDisplayName() {
    if(cachedDisplayName == null) {
      if(parent == null) cachedDisplayName = localName;
      else cachedDisplayName = parent.getDisplayName() + "." + localName; 
    }
    return cachedDisplayName;
  }

  @Override
  public Selector getParent() {
    return parent;
  }

  @Override
  public SelectorType getSelectorType() {
    return selectorType;
  }

  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof SelectorImpl)) return false;
    SelectorImpl sel = (SelectorImpl)obj;
    return getDisplayName().equals(sel.getDisplayName()) &&
      selectorType.equals(sel.selectorType);
  }

  @Override
  public int hashCode() {
    return getDisplayName().hashCode() + selectorType.hashCode();
  }
}
