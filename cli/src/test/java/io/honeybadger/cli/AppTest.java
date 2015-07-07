package io.honeybadger.cli;

import org.junit.Test;

public class AppTest {
    @Test(expected = java.lang.RuntimeException.class)
    public void appCanCallHoneybadgerWithoutError() {
        App.main(new String[] { System.getProperty("honeybadger.api_key") } );
    }
}
