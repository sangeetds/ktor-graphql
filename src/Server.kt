package com.example

import com.expediagroup.graphql.server.execution.GraphQLServer
import io.ktor.request.ApplicationRequest

class Server(requestParser: RequestParser, contextFactory: ContextFactory) : GraphQLServer<ApplicationRequest>(requestParser) {
}