package com.nambv.android_tv_sample.details

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter
import com.nambv.android_tv_sample.data.models.Movie

class DetailsDescriptionPresenter : AbstractDetailsDescriptionPresenter() {

    override fun onBindDescription(viewHolder: ViewHolder?, item: Any?) {
        val movie = item as Movie
        viewHolder?.title?.text = movie.getTitle()
        viewHolder?.subtitle?.text = movie.getOriginalTitle()
        viewHolder?.body?.text = movie.getOverview()
    }
}