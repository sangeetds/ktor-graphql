package com.example

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query

class DirectorQueryService : Query {

  suspend fun searchById(id: ID) = Director.search(id)
}
