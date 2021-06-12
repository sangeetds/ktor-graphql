package com.example

import com.expediagroup.graphql.generator.execution.GraphQLContext
import io.ktor.request.ApplicationRequest

class KtorContext(
  val request: ApplicationRequest,
  val headers: String?
) : GraphQLContext
