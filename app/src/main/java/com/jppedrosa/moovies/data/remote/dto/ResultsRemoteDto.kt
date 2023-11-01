package com.jppedrosa.moovies.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
class ResultsRemoteDto<T>(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: List<T>? = emptyList(),
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null
)
