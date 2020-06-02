package org.heroesunlimited

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class HeroSimulation extends Simulation {

  var baseUrl = "http://localhost:8100"
  val sessionHeaders = Map("Content-Type" -> "application/json")

  val httpProtocol = http
    .baseUrl(baseUrl)
    .headers(sessionHeaders)

  val csvPath = getClass.getResource("/herodata/heroes.csv")
  val csvFeeder = csv(csvPath.getPath)

  val scn = scenario("Hero Simulation Scenario")
    .feed(csvFeeder.random)
    .exec(
      http("Simple Build a Hero")
        .get("/api/players/name/${name}"))

  setUp(
    scn.inject(
      rampUsersPerSec(10) to 20 during (30 seconds)
    ).protocols(httpProtocol))
}
