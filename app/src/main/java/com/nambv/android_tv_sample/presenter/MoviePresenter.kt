package com.nambv.android_tv_sample.presenter

import android.support.v17.leanback.widget.Presenter
import android.view.ViewGroup

import com.nambv.android_tv_sample.MovieCardView
import com.nambv.android_tv_sample.data.models.Movie

/**
 * Make a MoviePresenter in order to tell the ArrayObjectAdapter how to render Movie objects.
 *
 * As you can see, the presenter is very simple in this case. All we needed to do here was create a new Presenter.ViewHolder
 * with the MovieCardView we created earlier.
 *
 * We could also add some type safety and check if the item is a instance of Movie and
 * if the View is a instance of MovieCardView, but we can ignore it for now as we know that all the ViewHolders will have a MovieCardView
 * and a Movie as an object.
 */
class MoviePresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): Presenter.ViewHolder {
        return Presenter.ViewHolder(MovieCardView(parent.context))
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) {
        (viewHolder.view as MovieCardView).bind(item as Movie)
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) = Unit
}