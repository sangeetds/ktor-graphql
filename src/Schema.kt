package com.example

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.toSchema
import graphql.schema.GraphQLSchema

val config = SchemaGeneratorConfig(supportedPackages = listOf("com.example"))
val queries = listOf(TopLevelObject(DirectorQueryService()), TopLevelObject(MovieQueryService()))
val schema: GraphQLSchema = toSchema(config, queries)