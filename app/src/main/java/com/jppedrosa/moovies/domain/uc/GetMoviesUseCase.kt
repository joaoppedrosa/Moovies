package com.jppedrosa.moovies.domain.uc

import com.jppedrosa.moovies.common.Resource
import com.jppedrosa.moovies.data.database.MooviesDatabase
import com.jppedrosa.moovies.data.database.entities.asDatabaseModel
import com.jppedrosa.moovies.data.database.entities.asDomainModel
import com.jppedrosa.moovies.domain.model.Movie
import com.jppedrosa.moovies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
class GetMoviesUseCase @Inject constructor(
    private val repository: Repository,
    private val database: MooviesDatabase
) {
    operator fun invoke(): Flow<Resource<List<Movie>?>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getMovies()
            val moviesList = response.results
            database.getMovieDao().insertAll(moviesList?.asDatabaseModel()) //TODO move this to the repository
            emit(Resource.Success(moviesList))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error!"))
        } catch (e: IOException) {
            //Load cache data if there is not internet connection
            val moviesList = database.getMovieDao().getAllMovies() //TODO move this to the repository
            if (moviesList.isNotEmpty()) {
                emit(Resource.Success(moviesList.asDomainModel()))
                return@flow
            }
            emit(Resource.Error("Check your internet connection"))
        }
    }
}