package com.jppedrosa.moovies

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.jppedrosa.moovies.domain.repository.Repository
import com.jppedrosa.moovies.domain.uc.GetMoviesUseCase
import com.jppedrosa.moovies.presentation.screens.home.HomeState
import com.jppedrosa.moovies.presentation.screens.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var getMoviesUseCase: GetMoviesUseCase

    @Captor
    private lateinit var captor: ArgumentCaptor<HomeState>

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = HomeViewModel(getMoviesUseCase)
    }

    @Test
    fun getMoviesSuccess() {
        /*runBlocking {
            val movieName1 = "titanic"
            val movieName2 = "harry potter"
            val movie1 = MovieDto(id = 1, title = movieName1)
            val movie2 = MovieDto(id = 2, title = movieName2)
            val movies = listOf(movie1, movie2)
            val resultsRemoteDto = ResultsRemoteDto(results = movies)

            val flow = flow<Resource<List<MovieDto>?>> {
                emit(Resource.Loading())
                delay(10)
                emit(Resource.Success(movies))
                delay(10)
            }

            `when`(getMoviesUseCase.invoke()).thenReturn(flow)
            viewModel.refresh()
            assertNotEquals(null, viewModel.state.value.error)
            assertEquals(false, viewModel.state.value.isLoading)
            assertEquals(1, viewModel.state.value.movies[0].id)
            assertEquals(2, viewModel.state.value.movies[1].id)
            assertEquals(movieName1, viewModel.state.value.movies[0].title)
            assertEquals(movieName2, viewModel.state.value.movies[1].title)
            assertEquals(2, viewModel.state.value.movies.size)
        }*/
    }

    @Test
    fun getMoviesFail() {
        runBlocking {
            /*whenever(repository.getMovies()).thenReturn(ResultsRemoteDto<MovieDto>())
            viewModel.refresh()
            assertNotEquals(null, viewModel.state.value.error)
            assertEquals(false, viewModel.state.value.isLoading)*/
        }
    }
}