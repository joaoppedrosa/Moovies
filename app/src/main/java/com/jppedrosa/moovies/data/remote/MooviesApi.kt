package com.jppedrosa.moovies.data.remote

import com.jppedrosa.moovies.data.remote.dto.MovieRemoteDto
import com.jppedrosa.moovies.data.remote.dto.ResultsRemoteDto
import retrofit2.http.GET

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
interface MooviesApi {

    @GET("movie/popular?language=en-US&page=1")
    suspend fun getMovies(): ResultsRemoteDto<MovieRemoteDto>

}