# Joe's Test Project for Kamon

I am attempting to get Kamon JDBC instrumentatino to work. It does not seem to be working for me even in the simplest scanario. I am trying to get it to at least log SQL errors.

In an attempt to at least verify that the processor is getting called when a JDBC SQL error occurs, I wrote my own simple processor, TestErrorLoggingProcessor that does some println() and also throws an exception. However, the process() method does not appear to be even getting called, as I don't see my println()s or exception in the console. Even if I put garbage value into "processors=" in application.conf, I don't get any errors or warnings. Not sure if I should expect that or not.

I also cannot access the Kamon status page. I added the kamon-status-page dependency to my Maven POM, but if I try to access localhost:5266 while my application is running, I get "localhost refused to connect"

Please ignore the project name (sparktest) and the reference to Postgres. This is a simplified version of the original project to demonstrate the issues. This test project does not currently use Spark or Postgres. It currently uses the H2 database.

## I am running this with the following command:
java -cp "target/sparktest-1.0-SNAPSHOT-jar-with-dependencies.jar:h2-1.4.199.jar:kanela-agent-1.0.1.jar" -javaagent:kanela-agent-1.0.1.jar H2TestNonSpark


