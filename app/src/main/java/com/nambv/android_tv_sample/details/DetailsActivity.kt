package com.nambv.android_tv_sample.details

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nambv.android_tv_sample.R
import com.nambv.android_tv_sample.data.models.Movie

class DetailsActivity : Activity() {

    companion object {

        const val EXT_MOVIE = "ext_movie"

        fun getInstance(context: Context?, movie: Movie): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXT_MOVIE, movie)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}
