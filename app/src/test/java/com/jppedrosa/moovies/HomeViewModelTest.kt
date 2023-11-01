package com.jppedrosa.moovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jppedrosa.moovies.domain.model.Movie
import com.jppedrosa.moovies.domain.repository.Repository
import com.jppedrosa.moovies.domain.uc.GetMoviesUseCase
import com.jppedrosa.moovies.presentation.screens.home.HomeViewModel
import com.jppedrosa.moovies.utils.MainCoroutineScopeRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
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
    val coroutineScope = MainCoroutineScopeRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var getMoviesUseCase: GetMoviesUseCase

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = HomeViewModel(getMoviesUseCase)
    }

    @Test
    fun getMoviesSuccess() {
        runBlocking {
            val movieName1 = "titanic"
            val movieName2 = "harry potter"
            val movie1 = Movie(id = "1", title = movieName1, image = "", description = "")
            val movie2 = Movie(id = "2", title = movieName2, image = "", description = "")
            val movies = listOf(movie1, movie2)
        }
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
