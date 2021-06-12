package com.example

import com.expediagroup.graphql.server.execution.GraphQLContextFactory
import io.ktor.request.ApplicationRequest

class ContextFactory: GraphQLContextFactory<, ApplicationRequest> {

}
