package com.example

import com.expediagroup.graphql.server.execution.GraphQLContextFactory
import io.ktor.request.ApplicationRequest

class ContextFactory: GraphQLContextFactory<KtorContext, ApplicationRequest> {

  override suspend fun generateContext(request: ApplicationRequest) = KtorContext(
    request = request,
    headers = request.headers["some-custom-request"]
  )
}
