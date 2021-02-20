package com.dewatwc.teamfootball.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dewatwc.teamfootball.R
import com.dewatwc.teamfootball.core.domain.model.Team
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailTeam = intent.getParcelableExtra<Team>(EXTRA_DATA)
        showDetailTeam(detailTeam)
    }

    private fun showDetailTeam(detailTeam: Team?) {
        detailTeam?.let {
            Glide.with(this)
                .load(detailTeam.img)
                .into(img_logo)
            name.text = detailTeam.name
            stadium.text = detailTeam.stadium
            desc.text = detailTeam.description

            var statusFavorite = detailTeam.isFavorite
            setStatusFavorite(statusFavorite)
            fav.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteTeam(detailTeam, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if(statusFavorite){
            fav.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        }else{
            fav.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border))
        }

    }
}