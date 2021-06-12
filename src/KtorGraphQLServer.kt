package com.example

import com.expediagroup.graphql.server.execution.GraphQLRequestHandler
import com.expediagroup.graphql.server.execution.GraphQLServer
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.request.ApplicationRequest

class KtorGraphQLServer(
  requestParser: RequestParser,
  contextFactory: ContextFactory,
  requestHandler: GraphQLRequestHandler
) : GraphQLServer<ApplicationRequest>(requestParser, contextFactory, requestHandler)

fun getGraphQLServer(objectMapper: ObjectMapper): KtorGraphQLServer {
  val requestParser = RequestParser(objectMapper)
  val contextFactory = ContextFactory()
  val requestHandler = GraphQLRequestHandler(graphQL)

  return KtorGraphQLServer(requestParser, contextFactory, requestHandler)
}