package com.example.moviedisplayapp.api

import com.example.moviedisplayapp.Constants
import com.example.moviedisplayapp.models.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET(TRENDING_MOVIES)
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY
    ) : MoviesResponse

    companion object {
        const val TRENDING_MOVIES = "3/trending/movie/week"
    }
}