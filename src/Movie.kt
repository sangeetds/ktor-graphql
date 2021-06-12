package com.example

import com.expediagroup.graphql.generator.scalars.ID

data class Movie(
  val id: ID,
  val name: String,
  val runTime: Int,
  val directorId: ID
) {
  companion object {
    suspend fun searchMovie(id: ID) = movies.find { it.id == id }
  }
}

val movies = listOf(
  Movie(id = ID("1"), name = "Interstellar", runTime = 136, directorId = ID("1")),
  Movie(id = ID("2"), name = "Jurassic Park", runTime = 176, directorId = ID("2")),
  Movie(id = ID("3"), name = "Avengers", runTime = 123, directorId = ID("4")),
  Movie(id = ID("4"), name = "Spider Man", runTime = 140, directorId = ID("3")),
  Movie(id = ID("5"), name = "InterStellar", runTime = 176, directorId = ID("1"))
)
