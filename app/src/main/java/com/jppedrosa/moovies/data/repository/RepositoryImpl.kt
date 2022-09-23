package com.jppedrosa.moovies.data.repository

import com.jppedrosa.moovies.data.dto.MovieDto
import com.jppedrosa.moovies.data.dto.Results
import com.jppedrosa.moovies.data.remote.TmdbApi
import com.jppedrosa.moovies.domain.repository.Repository
import javax.inject.Inject

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
class RepositoryImpl @Inject constructor(
    private val api: TmdbApi
) : Repository {

    override suspend fun getMovies(): Results<MovieDto> {
        return api.getMovies()
    }
}

