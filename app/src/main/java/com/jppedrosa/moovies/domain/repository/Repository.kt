package com.jppedrosa.moovies.domain.repository

import com.jppedrosa.moovies.domain.model.Movie
import com.jppedrosa.moovies.domain.model.Results

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 22/09/2022.
 */
interface Repository {
    suspend fun getMovies(): Results<Movie>
}
