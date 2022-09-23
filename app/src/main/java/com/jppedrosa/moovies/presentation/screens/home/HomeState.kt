package com.jppedrosa.moovies.presentation.screens.home

import com.jppedrosa.moovies.data.dto.MovieDto

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
data class HomeState(
    val isLoading: Boolean = false,
    val movies: List<MovieDto> = emptyList(),
    val error: String = ""
)