package org.scalasbt.testing.adapt;

import org.scalasbt.testing.Event;
import org.scalasbt.testing.EventHandler;

/**
 * An adapter from an old EventHandler to a new one, to simplify the
 * implementation of test frameworks which implement both, the old and
 * the new test interface.
 */
public final class EventHandlerAdapter implements EventHandler {
  private org.scalatools.testing.EventHandler eventHandler;

  public EventHandlerAdapter(org.scalatools.testing.EventHandler eventHandler) {
    this.eventHandler = eventHandler;
  }

  @Override
  public void handle(Event event) {
    eventHandler.handle(new ReverseEventAdapter(event));
  }
}
