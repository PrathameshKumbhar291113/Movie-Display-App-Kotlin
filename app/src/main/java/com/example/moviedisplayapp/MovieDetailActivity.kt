package com.example.moviedisplayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.moviedisplayapp.adapter.MoviesAdapter
import com.example.moviedisplayapp.databinding.ActivityHomeBinding
import com.example.moviedisplayapp.databinding.ActivityMovieDetailBinding
import com.example.moviedisplayapp.models.Result

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val args = intent.getParcelableExtra<Result>("movie")
        if (args != null){
            binding.moviePoster.apply {
                load(
                    "https://image.tmdb.org/t/p/w500" + args.poster_path
                ) {
                    crossfade(true)
                }
            }
            binding.movieTitle.text = args.title
            binding.movieOverview.text = args.overview
            binding.moviePopularity.text= args.popularity.toString()
            binding.movieVoteCount.text = args.vote_count.toString()
            binding.movieReleaseDate.text = args.release_date

        }
    }
}