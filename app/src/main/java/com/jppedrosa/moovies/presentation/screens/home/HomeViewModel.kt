package com.jppedrosa.moovies.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jppedrosa.moovies.common.Resource
import com.jppedrosa.moovies.domain.uc.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getMovies()
    }

    /**
     * Get list of movies
     *
     */
    private fun getMovies() {
        this.getMoviesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    this._state.value = HomeState(movies = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    this._state.value = HomeState(error = result.message ?: "Unexpected error!")
                }
                is Resource.Loading -> {
                    this._state.value = HomeState(isLoading = true)
                }
            }
        }.launchIn(this.viewModelScope)
    }
}