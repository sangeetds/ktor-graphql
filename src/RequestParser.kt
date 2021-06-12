package com.example

import com.expediagroup.graphql.server.execution.GraphQLRequestParser
import com.expediagroup.graphql.server.types.GraphQLServerRequest
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.ktor.request.ApplicationRequest
import io.ktor.request.receiveText
import io.ktor.utils.io.errors.IOException

class RequestParser(private val objectMapper: ObjectMapper) : GraphQLRequestParser<ApplicationRequest> {

  override suspend fun parseRequest(request: ApplicationRequest): GraphQLServerRequest = try {
    val rawRequest = request.call.receiveText()
    objectMapper.readValue(rawRequest)
  } catch (e: IOException) {
    throw IOException("Unable to parse GraphQL payload.")
  }
}
