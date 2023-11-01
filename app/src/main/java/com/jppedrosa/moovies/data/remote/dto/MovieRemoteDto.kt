package com.jppedrosa.moovies.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.jppedrosa.moovies.common.utils.ImageUtils
import com.jppedrosa.moovies.data.database.entities.MovieEntity
import com.jppedrosa.moovies.domain.model.Movie

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
data class MovieRemoteDto(
    @SerializedName("adult")
    var adult: Boolean? = null,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    @SerializedName("genre_ids")
    var genreIds: ArrayList<Int> = arrayListOf(),
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("original_title")
    var originalTitle: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("popularity")
    var popularity: Double? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("video")
    var video: Boolean? = null,
    @SerializedName("vote_average")
    var voteAverage: Double? = null,
    @SerializedName("vote_count")
    var voteCount: Int? = null
)

/**
 * Convert remote response to domain layer data object
 */
fun List<MovieRemoteDto>.asDomainModel(): List<Movie> {
    return map {
        Movie(
            id = it.id.toString(),
            title = it.title,
            description = it.overview,
            image = ImageUtils.getTmdbUrlImage(it.posterPath)
        )
    }
}

/**
 * Convert remote response to database layer data object
 */
fun List<MovieRemoteDto>.asDatabaseModel(): List<MovieEntity> {
    return map {
        MovieEntity(
            id = it.id.toString(),
            title = it.title,
            description = it.overview,
            image = ImageUtils.getTmdbUrlImage(it.posterPath)
        )
    }
}
