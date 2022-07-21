package com.example.moviedisplayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviedisplayapp.adapter.MoviesAdapter
import com.example.moviedisplayapp.databinding.ActivityHomeBinding

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
    }

    private fun setupRecyclerView() {
        adapter = MoviesAdapter { result ->
            //TODO Navigate to next screen when image is clicked
        }
        binding.moviesList.adapter = adapter
    }
}