## Spring Boot crywolf example app

This is a minimalist Spring Boot application that 

It should work with any version of the JDK from Java 8-12.

## Running

In your shell:
````
mvn install
export HONEYBADGER_API_KEY=[yourkey] 
java -jar target/crywolf-spring-0.1.0.jar
````

The page that sends an error to HoneyBadger is http://localhost/8080/error2