package org.scalasbt.testing.adapt;

import org.scalasbt.testing.Logger;

/**
 * An adapter from an old Logger to a new one, to simplify the
 * implementation of test frameworks which implement both, the old and
 * the new test interface.
 */
public final class LoggerAdapter implements Logger {
  private final org.scalatools.testing.Logger logger;

  public LoggerAdapter(org.scalatools.testing.Logger logger) {
    this.logger = logger;
  }

  @Override
  public boolean ansiCodesSupported() {
    return logger.ansiCodesSupported();
  }

  @Override
  public void error(String msg) {
    logger.error(msg);
  }

  @Override
  public void warn(String msg) {
    logger.warn(msg);
  }

  @Override
  public void info(String msg) {
    logger.info(msg);
  }

  @Override
  public void debug(String msg) {
    logger.debug(msg);
  }

  @Override
  public void trace(Throwable t) {
    logger.trace(t);
  }

  /**
   * Adapt an array of old loggers to the new interface.
   */
  public static Logger[] adapt(org.scalatools.testing.Logger[] loggers) {
    Logger[] a = new Logger[loggers.length];
    for(int i=0; i<a.length; i++)
      a[i] = new LoggerAdapter(loggers[i]);
    return a;
  }
}
