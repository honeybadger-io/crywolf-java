package io.honeybadger.cli;

import io.honeybadger.reporter.HoneybadgerReporter;
import io.honeybadger.reporter.HoneybadgerUncaughtExceptionHandler;

import java.util.Scanner;

/**
 * Example CLI invocation of Honeybadger via a uncaught exception handler.
 */
public class App
{
    public static void main( String[] args )
    {
        String apiKey = args.length > 0 ?
                args[0] :
                System.getenv("HONEYBADGER_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println("HONEYBADGER_API_KEY environment variable not " +
                    "set");

            try (Scanner in = new Scanner(System.in)) {
                System.out.print("What is your Honeybadger API key: ");
                apiKey = in.nextLine().trim();

                System.out.print("\n");
            }
        }

        System.setProperty(HoneybadgerReporter.HONEYBADGER_API_KEY_SYS_PROP_KEY, apiKey);

        System.out.println(String.format("Your API key is: [%s]",
                System.getProperty(HoneybadgerReporter.HONEYBADGER_API_KEY_SYS_PROP_KEY)));

        HoneybadgerUncaughtExceptionHandler.registerAsUncaughtExceptionHandler();
        System.out.println("Failing...");

        throw new RuntimeException("Testing honeybadger.");
    }
}
