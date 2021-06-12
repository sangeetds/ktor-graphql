package com.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

inline fun <reified T> ObjectMapper.writeAsString(value: T): String = writeValueAsString(value)

class Server {

  private val objectMapper = jacksonObjectMapper()
  private val graphQLServer = getGraphQLServer(objectMapper)

  suspend fun handle(applicationCall: ApplicationCall) {
    // Execute the query against the schema
    val result = graphQLServer.execute(applicationCall.request)

    if (result != null) {
      // write response as json
      val json = objectMapper.writeAsString(result)
      applicationCall.response.call.respond(json)
    } else {
      applicationCall.response.call.respond(HttpStatusCode.BadRequest, "Invalid request")
    }
  }
}