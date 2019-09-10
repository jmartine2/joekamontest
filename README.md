# Scrappy Test Project for Spark Apps

## Setup
Copy log4j.properties to /path/to/spark/home/conf/ to configure spark to write logs to /var/log/spark.log
Otherwise, logs will just go to the console.

## Running an app in spark locallly
For example, to run the PostgresTest app:

1) Copy the postgresql-42.2.6.jar jar to this directory
2) Build the maven package
```
mvn package
```
3) Submit to spark
```
/path/to/spark-submit --jars postgresql-42.2.6.jar --driver-class-path postgresql-42.2.6.jar --class PostgresTest target/sparktest-1.0-SNAPSHOT-jar-with-dependencies.jar
