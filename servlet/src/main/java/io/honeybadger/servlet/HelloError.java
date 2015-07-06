package io.honeybadger.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Simple servlet that throws an error when /error is invoked otherwise it outputs outputs "Hello World"
 */
public class HelloError extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public HelloError() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/plain");

        final String requestURI = req.getRequestURI();

        logger.info("Requested URI is: {}", requestURI);

        if (requestURI.endsWith("error") || requestURI.endsWith("error/")) {
            resp.getWriter().append("Hello Error");

            throw new RuntimeException("I'm an error that will get thrown to Honeybadger");
        } else {
            resp.getWriter().append("Hello World");
        }
    }
}
