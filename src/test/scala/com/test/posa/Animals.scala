package com.test.posa

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

import scala.concurrent.duration._

class Animals extends Simulation {

  val httpConfAnimals = http
    .baseURL("http://localhost:8092")
    .acceptHeader("text/html,application/xhtml+xml,application/xml,application/json;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val getAnimalsScenario = scenario("Animals")
    .exec(http("Get Animals")
      .get("/animals/api/animals")
      .header(HttpHeaderNames.ContentType, "application/json")
      .check(status.is(200))
    )

  // Setup - 1000 Users over 1 Minute - Make the get requests
//  setUp(
//    getDogsScenario.inject(rampUsers(1000) over 1.minutes).protocols(httpConfDogs)
//  )

  // At once Usage - It will call endpoint 1000 times and make sure that we have status 200
//  setUp(
//    getDogsScenario.inject(atOnceUsers(1000))
//  ).protocols(httpConfDogs)

  // Setup Throttle Example - Rampup 30 Users, 10 Requests per second, Execution duration 1 Minute
  setUp(
    getAnimalsScenario.inject(rampUsers(30) over 1.seconds).protocols(httpConfAnimals)).throttle(reachRps(10) in 10.seconds , holdFor(1 minutes)
  )
}
