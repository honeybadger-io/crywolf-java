package io.honeybadger.cli;

import io.honeybadger.reporter.HoneybadgerUncaughtExceptionHandler;
import io.honeybadger.reporter.config.ConfigContext;
import io.honeybadger.reporter.config.StandardConfigContext;
import io.honeybadger.reporter.config.SystemSettingsConfigContext;

import java.util.Scanner;

/**
 * Example CLI invocation of Honeybadger via a uncaught exception handler.
 */
public class App
{
    public static void main( String[] args )
    {
        ConfigContext configContext;

        // Manually load configuration if it is specified as the first arg
        if (args.length > 0) {
            configContext = new StandardConfigContext(args[0]);
        // Otherwise, default to system settings
        } else {
            configContext = new SystemSettingsConfigContext();
        }

        // If we can't get a valid API key out of either of these configurations,
        // then we prompt the user.
        if (configContext.getApiKey() == null || configContext.getApiKey().isEmpty()) {
            System.err.println("HONEYBADGER_API_KEY environment variable or " +
                    "system setting not set");

            try (Scanner in = new Scanner(System.in)) {
                System.out.print("What is your Honeybadger API key: ");
                String apiKey = in.nextLine().trim();
                configContext = new StandardConfigContext(apiKey);
                System.out.print("\n");
            }
        }

        System.out.println(String.format("Your API key is: [%s]",
                configContext.getApiKey()));

        HoneybadgerUncaughtExceptionHandler.registerAsUncaughtExceptionHandler(configContext);
        System.out.println("Failing...");

        try {
            throw new RuntimeException("Testing honeybadger from crywolf.");
        } finally {
            System.out.println("Exiting...");
        }
    }
}
