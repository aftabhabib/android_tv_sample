package com.nambv.android_tv_sample

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nambv.android_tv_sample.data.models.Movie
import com.nambv.android_tv_sample.di.HttpClientModule
import kotlinx.android.synthetic.main.item_card_movie.view.*
import java.util.*

class MovieCardView(context: Context) : BindableCardView<Movie>(context) {

    override fun bind(data: Movie) {

        Glide.with(context)
                .load(HttpClientModule.POSTER_URL + data.getPosterPath())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(posterImage)

        tvPopularity.text = String.format(Locale.getDefault(), "%.2f", data.getVoteAverage())
    }

    override fun getLayoutResource(): Int = R.layout.item_card_movie
}