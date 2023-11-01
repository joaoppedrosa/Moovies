package com.jppedrosa.moovies.data.repository

import com.jppedrosa.moovies.data.remote.MooviesApi
import com.jppedrosa.moovies.data.remote.dto.asDomainModel
import com.jppedrosa.moovies.domain.model.Movie
import com.jppedrosa.moovies.domain.model.Results
import com.jppedrosa.moovies.domain.repository.Repository
import javax.inject.Inject

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
class RepositoryImpl @Inject constructor(
    private val api: MooviesApi
) : Repository {

    override suspend fun getMovies(): Results<Movie> {
        val response = api.getMovies()
        val moviesList = response.results?.asDomainModel()
        return Results(
            page = response.page,
            results = moviesList,
            totalPages = response.totalPages,
            totalResults = response.totalResults
        )
    }
}
