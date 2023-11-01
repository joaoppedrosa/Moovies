package com.jppedrosa.moovies.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jppedrosa.moovies.domain.model.Movie

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 26/09/2022.
 */

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: String,
    val title: String?,
    val description: String?,
    val image: String?
)

/**
 * Convert domain to database layer data object
 */
fun List<Movie>.asDatabaseModel(): List<MovieEntity> {
    return map {
        MovieEntity(
            id = it.id,
            title = it.title,
            description = it.description,
            image = it.image
        )
    }
}

/**
 * Convert database to domain layer data object
 */
fun List<MovieEntity>.asDomainModel(): List<Movie> {
    return map {
        Movie(
            id = it.id,
            title = it.title,
            description = it.description,
            image = it.image
        )
    }
}
