import kamon.instrumentation.jdbc.JdbcInstrumentation.FailedStatementProcessor

class TestErrorLoggingProcessor extends FailedStatementProcessor {
    override def process(sql: String, ex: Throwable): Unit = {
        printf("***************** Kamon reports JDBC Error**********************")
        printf(s"*** sql = $sql")
        printf(s"*** exception message = ${ex.getMessage}")
        printf("****************************************************************")
        throw new Exception("Yo Yo Yo Bad SQL stuff here!")
    }
}
