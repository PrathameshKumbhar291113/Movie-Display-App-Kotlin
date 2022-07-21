package com.example.moviedisplayapp.models

import androidx.annotation.Keep

@Keep
data class MoviesResponse(
    var page: Int? = null,
    var results: List<Result>? = null,
    var total_pages: Int? = null,
    var total_results: Int? = null
)