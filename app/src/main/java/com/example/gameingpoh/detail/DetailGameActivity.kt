package com.example.gameingpoh.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.core.domain.model.Game
import com.example.gameingpoh.R
//import com.example.gameingpoh.core.ui.ViewModelFactory
import com.example.gameingpoh.databinding.ActivityDetailGameBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailGameActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

   // private lateinit var detailTourismViewModel: DetailGameViewModel
   private val detailTourismViewModel: DetailGameViewModel by viewModel()

    private lateinit var binding: ActivityDetailGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val factory = ViewModelFactory.getInstance(this)
//        detailTourismViewModel = ViewModelProvider(this, factory)[DetailGameViewModel::class.java]

        val detailTourism = intent.getParcelableExtra<Game>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailGame: Game?) {
        detailGame?.let {
            supportActionBar?.title = detailGame.name
            binding.content.tvDetailDescription.text = detailGame.name
            Glide.with(this@DetailGameActivity)
                .load(detailGame.backgroundImage)
                .into(binding.ivDetailImage)

            var statusFavorite = detailGame.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setFavoriteGame(detailGame, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_yes))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_no))
        }
    }
}