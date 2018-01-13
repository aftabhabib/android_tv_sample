package com.nambv.android_tv_sample.presenter

import android.content.Context
import android.support.v17.leanback.widget.ImageCardView
import android.support.v17.leanback.widget.Presenter
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import com.nambv.android_tv_sample.R
import com.nambv.android_tv_sample.data.models.Movie
import com.nambv.android_tv_sample.util.loadImage

/*
**
 * Make a CardPresenter in order to tell the ArrayObjectAdapter how to render Movie objects.
 *
 * As you can see, the presenter is very simple in this case. All we needed to do here was create a new Presenter.ViewHolder
 * with the MovieCardView we created earlier.
 *
 * We could also add some type safety and check if the item is a instance of Movie and
 * if the View is a instance of MovieCardView, but we can ignore it for now as we know that all the ViewHolders will have a MovieCardView
 * and a Movie as an object.
 */
class CardPresenter : Presenter() {

    private var mContext: Context? = null

    companion object {
        val CARD_WIDTH = 275
        val CARD_HEIGHT = 375
    }

    class ViewHolder(view: View) : Presenter.ViewHolder(view) {

        var mCardView: ImageCardView? = null
        init {
            mCardView = view as ImageCardView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        mContext = parent?.context

        val cardView = ImageCardView(mContext)
        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        cardView.setBackgroundColor(ContextCompat.getColor(mContext!!, R.color.fastlane_background))

        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder?, item: Any?) {
        val movie = item as Movie

        (viewHolder as ViewHolder).mCardView?.titleText = movie.getTitle()
        viewHolder.mCardView?.contentText = movie.getOriginalTitle()
        viewHolder.mCardView?.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)
        viewHolder.mCardView?.mainImage = ContextCompat.getDrawable(mContext!!, R.drawable.movie)
        viewHolder.mCardView?.loadImage(movie.getPosterPath())
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) = Unit
}
