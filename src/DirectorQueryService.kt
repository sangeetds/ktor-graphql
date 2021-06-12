package com.example

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query

class DirectorQueryService : Query {

  suspend fun searchDirectorById(id: ID) = Director.searchById(id)
}
