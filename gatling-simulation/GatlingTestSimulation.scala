package gatlingtest

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class GatlingTestSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080")

    val login = exec(http("login_request").get("/login"))
    val calculate = exec(http("pi_request").get("/pi"))

    val scn = scenario("Testing session-PI").exec(login,calculate)


  setUp(scn.inject(atOnceUsers(50)).protocols(httpProtocol))
}