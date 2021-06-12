package com.example

import com.expediagroup.graphql.generator.scalars.ID

data class Director(
  val id: ID,
  val name: String,
  val age: Int
) {
  companion object {
    suspend fun searchById(id: ID) = directors.find { it.id == id }
  }
}

val directors = listOf(
  Director(id = ID("1"), name = "Christopher Nolan", age = 45),
  Director(id = ID("2"), name = "Steven Spielberg", age = 56),
  Director(id = ID("3"), name = "Sam Raimi", age = 52),
  Director(id = ID("4"), name = "Joss Whedon", age = 49)
)
