package com.example.moviedisplayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviedisplayapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate the layout & get binding instance
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup the RecyclerView first when screen loads
    }

    private fun setupRecyclerView() {
        //TODO create an adapter for recyclerview
        binding.moviesList.adapter
    }
}