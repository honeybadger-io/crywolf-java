package io.honeybadger.cli;

import org.junit.Test;

public class AppTest {
    @Test(expected = java.lang.RuntimeException.class)
    public void appCanCallHoneybadgerWithoutError() {
        // Note: UncaughtExceptionHandler will not be called because JUnit
        // short-circuits any calls to it. To properly test this call invoke
        // it directly using the instructions in 'cli-run-examples.txt'.
        App.main(new String[] { });
    }
}
