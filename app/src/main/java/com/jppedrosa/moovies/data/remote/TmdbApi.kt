package com.jppedrosa.moovies.data.remote

import com.jppedrosa.moovies.data.dto.MovieDto
import com.jppedrosa.moovies.data.dto.Results
import retrofit2.http.GET

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
interface TmdbApi {

    @GET("movie/popular?language=en-US&page=1")
    suspend fun getMovies(): Results<MovieDto>

}