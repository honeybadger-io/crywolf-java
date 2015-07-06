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

        if (apiKey == null) {
            System.err.println("HONEYBADGER_API_KEY environment variable not " +
                    "set");

            Scanner in = new Scanner(System.in);

            System.out.print("What is your Honeybadger API key: ");
            apiKey = in.nextLine();

            System.out.print("\n");
        }

        System.setProperty(HoneybadgerReporter.HONEYBADGER_API_KEY_SYS_PROP_KEY, apiKey);
        HoneybadgerUncaughtExceptionHandler.registerAsUncaughtExceptionHandler();
        System.out.printf("Failing... %s", apiKey);
        throw new RuntimeException("Testing honeybadger.");
    }
}
