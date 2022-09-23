package com.jppedrosa.moovies.domain.uc

import com.jppedrosa.moovies.common.Resource
import com.jppedrosa.moovies.data.dto.MovieDto
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
    private val repository: Repository
) {
    operator fun invoke(): Flow<Resource<List<MovieDto>?>> = flow {
        try {
            emit(Resource.Loading())
            val images = repository.getMovies()
            emit(Resource.Success(images.results))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error!"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }
}