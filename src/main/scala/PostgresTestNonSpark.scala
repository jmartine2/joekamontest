import java.sql.DriverManager

import com.typesafe.config.ConfigFactory
import kamon.Kamon
//import kamon.instrumentation.jdbc.JdbcInstrumentation
//import kamon.instrumentation.jdbc.JdbcInstrumentation.LoggingProcessors

object H2TestNonSpark extends App {

    ConfigFactory.load()
    Kamon.init()

//    Kamon.loadReportersFromConfig()
    printf("@@@@@@@@@@@@@@@@@@@@@@@@@@")
    printf(Kamon.config().toString)
    printf("@@@@@@@@@@@@@@@@@@@@@@@@@@")

    val url = "jdbc:h2:mem:hikari-tracing-spec;MULTI_THREADED=1"
//    println("H2 Initializing driver")
//    Class.forName("org.h2.Driver")

//    val span = Kamon.buildSpan("joe-non-spark-test").start()
    var counter = 1
    while (true) {
        println("H2 getting connection")
        val connection = DriverManager.getConnection(url, "SA", "")

        val select = s"SELECT * FROM NotATable where Nr = 1"

        println("H2 creating statement")
        val statement = connection.createStatement()

        println("H2 executing statement")

//        statement.execute(select)
        try {
            statement.execute(select)
        }
        catch {
            case serr: Exception => {
                println(serr)
            }
        }
        finally {
            println("In finally clause")
            //            span.mark("Finishing span")
            //            span.finish
        }

        Thread.sleep(3000)
        println(s"Sleeping $counter")
        counter += 1
    }

    println("H2 Done")
}

