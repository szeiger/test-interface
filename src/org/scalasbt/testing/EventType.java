package org.scalasbt.testing;

public enum EventType
{
  /**
   * Indicates a test succeeded.
   */
  Success,
	
	/**
	 * An event that indicates an error occurred.
	 *
	 * <p>
	 * Implementing test frameworks can decide how to differentiate between "failures" and
	 * "errors." JUnit reports assertion failures as "failures," and any other problems as "errors,"
	 * so many users may expect these meanings.
	 * </p>
	 */
	Error,
	
	/**
	 * An event that indicates a failure occurred.
	 *
	 * <p>
	 * Implementing test frameworks can decide how to differentiate between "failures" and
	 * "errors." JUnit reports assertion failures as "failures," and any other problems as "errors,"
	 * so many users may expect these meanings.
	 * </p>
	 */
	Failure,
	
	/**
	 * An event that indicates a test was cancelled because of some unmet precondition.
	 *
	 * <p>
	 * A <em>canceled</em> test is one that was not able to run because of some unmet
	 * precondition, such as a database not being present on the network. The test did
	 * not fail or succeed, because it was not given a chance to run.
	 * </p>
	 */
	Skipped
}