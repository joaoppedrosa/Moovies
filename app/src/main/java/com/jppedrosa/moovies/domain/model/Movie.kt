package com.jppedrosa.moovies.domain.model

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 26/09/2022.
 */
data class Movie(
    val id: String,
    val title: String?,
    val description: String?,
    val image: String?
)
