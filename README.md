# Joe's Test Project for Kamon

## I am attempting to get Kamon JDBC instrumentatino to work. It does not seem to be working for me even in the simplest scanario. I am trying to get it to at least log SQL errors.

## In an attempt to at least verify that the processor is getting called when a JDBC SQL error occurs, I wrote my own simple processor, TestErrorLoggingProcessor that does some println() and also throws an exception. However, the process() method does not appear to be even getting called.

## I am running this with the following command:
java -cp "target/sparktest-1.0-SNAPSHOT-jar-with-dependencies.jar:h2-1.4.199.jar:kanela-agent-1.0.1.jar" -javaagent:kanela-agent-1.0.1.jar H2TestNonSpark


