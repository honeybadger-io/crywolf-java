package io.honeybadger.cli;

import org.junit.Test;

public class AppTest {
    @Test(expected = java.lang.RuntimeException.class)
    public void appCanCallHoneybadgerWithoutError() {
        final String apiKey;

        if (System.getProperty("honeybadger.api_key") != null) {
            apiKey = System.getProperty("honeybadger.api_key");
        } else {
            apiKey = System.getenv("HONEYBADGER_API_KEY");
        }

        App.main(new String[] { apiKey });
    }
}
