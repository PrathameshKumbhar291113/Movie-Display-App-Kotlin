package com.example.moviedisplayapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.moviedisplayapp.adapter.MoviesAdapter
import com.example.moviedisplayapp.api.ApiService
import com.example.moviedisplayapp.databinding.ActivityHomeBinding
import kotlinx.coroutines.launch
import splitties.activities.start
import splitties.snackbar.snack
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class HomeActivity : AppCompatActivity() {

    private lateinit var adapter: MoviesAdapter
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate the layout & get binding instance
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup the RecyclerView first when screen loads
        setupRecyclerView()

        //Finally we will call our api to fetch our data
        lifecycleScope.launch {
            getTrendingMovies()
        }
    }

    private fun setupRecyclerView() {
        adapter = MoviesAdapter { result ->
            //TODO Navigate to next screen when image is clicked
            start<MovieDetailActivity>(){
                putExtra("movie",result)
            }
        }
        binding.moviesList.adapter = adapter
    }

    suspend fun getTrendingMovies() {
        try {
            val movies = ApiService.restService.getTrendingMovies()
            if(!movies.results.isNullOrEmpty()) {
                //We definitely have results for movies
                adapter.differ.submitList(movies.results)
            } else {
                binding.root.snack("No movies are Trending! Everyone is watching Netflix")
            }
        } catch (e: Exception) {
            with(binding.root) {
                when(e) {
                    is ConnectException -> snack("No Internet Connection Available!")
                    is UnknownHostException -> snack("You connection was reset")
                    is SocketTimeoutException -> snack("Failed to get Movies. Try Again")
                    else -> snack("Something went wrong, Please Try Again")
                }
            }
        }
    }
}