package org.scalatools.testing2;

public interface Runner {

    /**
     * Gets a task that will execute one test class, possibly returning more tasks.
     * (We don't need the fingerprint in ScalaTest. If no one else needs it, perhaps 
     * we should drop it.) Should only be called during "run mode."
     */

    // This one can be used to rerun failed tests
    public Task getTask(String testClassName, TestId[] testIds, Fingerprint fingerprint);

    // This one can be used to just run discovered test classes
    public Task getTask(String testClassName, Fingerprint fingerprint);

    // This one can be used to rerun aborted suites
    public Task getTask(String testClassName, String suiteId, Fingerprint fingerprint);

    /**
     * Returns a summary string, a string suitable for displaying to the user. sbt can decide
     * whether to use the string summary and show that to the user.
     * For example, if only using ScalaTest, better to show the
     * ScalaTest summary. But if they are using multiple test frameworks,
     * better to show the sbt summary.
     *
     * At this time the test framework should clean up any resources
     * associated with the run, so sbt should only call it once
     * the run is completed. Runner is defunct after summarize returns and
     * cannot be reused.
     */
    // Have logger, passed to testRunner method of Framework, so can decide whether
    // to return  string with ansi color codes in it or not.
    public String summarize(RunStatus status);
}