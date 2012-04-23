package org.scalasbt.testing.adapt;

import org.scalatools.testing.Event;
import org.scalatools.testing.Result;

/**
 * An adapter from a new Event to an old one, to simplify the
 * implementation of test frameworks which implement both, the old and
 * the new test interface.
 */
public class ReverseEventAdapter implements Event {

  private final org.scalasbt.testing.Event event;
  
  public ReverseEventAdapter(org.scalasbt.testing.Event event) {
    this.event = event;
  }
  
  @Override
  public String testName() {
    return event.getDisplayName();
  }

  @Override
  public String description() {
    return null; // not actually used
  }

  @Override
  public Result result() {
    switch(event.getEventType()) {
      case Success: return Result.Success;
      case Error: return Result.Error;
      case Skipped: return Result.Skipped;
      case Failure: return Result.Failure;
    }
    throw new IllegalArgumentException();
  }

  @Override
  public Throwable error() {
    return event.getCause();
  }
}
