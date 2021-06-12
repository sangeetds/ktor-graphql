package com.example

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query

class MovieQueryService : Query {

  suspend fun searchById(id: ID) = Movie.search(id)
}