package com.example

import com.expediagroup.graphql.server.execution.GraphQLRequestParser
import com.expediagroup.graphql.server.types.GraphQLServerRequest
import io.ktor.request.ApplicationRequest
import io.ktor.request.receiveText
import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RequestParser : GraphQLRequestParser<ApplicationRequest> {

  override suspend fun parseRequest(request: ApplicationRequest): GraphQLServerRequest = try {
    val rawRequest = request.call.receiveText()
    Json.decodeFromString(rawRequest)
  } catch (e: IOException) {
    throw IOException("Unable to parse GraphQL payload.")
  }
}
