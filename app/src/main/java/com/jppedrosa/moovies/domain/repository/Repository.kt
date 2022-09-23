package com.jppedrosa.moovies.domain.repository

import com.jppedrosa.moovies.data.dto.MovieDto
import com.jppedrosa.moovies.data.dto.Results

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 22/09/2022.
 */
interface Repository {
    suspend fun getMovies(): Results<MovieDto>
}