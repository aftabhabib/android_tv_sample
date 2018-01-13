package com.nambv.android_tv_sample.details

import android.os.Bundle
import android.support.v17.leanback.app.DetailsFragment
import android.support.v17.leanback.widget.*
import android.support.v17.leanback.widget.ListRow
import com.nambv.android_tv_sample.GlideBackgroundManager
import com.nambv.android_tv_sample.data.models.Movie
import com.nambv.android_tv_sample.presenter.CardPresenter
import com.nambv.android_tv_sample.util.convertDpToPixel
import com.nambv.android_tv_sample.util.loadImageBitmap
import com.nambv.android_tv_sample.util.showToast
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class VideoDetailsFragment : DetailsFragment() {

    private lateinit var mGlideBackgroundManager: GlideBackgroundManager

    private var mSelectedMovie: Movie? = null
    private var mDetailOverviewRowPresenter: CustomFullWidthDetailsOverviewRowPresenter? = null

    companion object {
        const val DETAIL_THUMB_WIDTH = 275
        const val DETAIL_THUMB_HEIGHT = 375

        const val ACTION_WATCH_VIDEO = 1
        const val ACTION_VIEW_TRAILER = 2
        const val ACTION_DOWNLOAD = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mGlideBackgroundManager = GlideBackgroundManager(activity)
        mDetailOverviewRowPresenter = CustomFullWidthDetailsOverviewRowPresenter(DetailsDescriptionPresenter())

        mSelectedMovie = activity.intent?.getParcelableExtra(DetailsActivity.EXT_MOVIE)
        mGlideBackgroundManager.updateBackgroundWithDelay(mSelectedMovie?.getBackdropPath())

        bindMovieDetails()
    }

    private fun bindMovieDetails() {

        createDetailRow()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object : DisposableSingleObserver<DetailsOverviewRow>() {
                    override fun onSuccess(row: DetailsOverviewRow) {

                        // 1st section: Display details Action Row
                        val sparseArrayObjectAdapter = SparseArrayObjectAdapter()
                        sparseArrayObjectAdapter.set(ACTION_WATCH_VIDEO, Action(ACTION_WATCH_VIDEO.toLong(), "Watch Video", ""))
                        sparseArrayObjectAdapter.set(ACTION_VIEW_TRAILER, Action(ACTION_VIEW_TRAILER.toLong(), "View Trailer", ""))
                        sparseArrayObjectAdapter.set(ACTION_DOWNLOAD, Action(ACTION_DOWNLOAD.toLong(), "Download", ""))

                        row.actionsAdapter = sparseArrayObjectAdapter

                        val headerItem = HeaderItem(0, "Related Videos")
                        val listRowAdapter = ArrayObjectAdapter(CardPresenter())
                        for (i in 1..10) {
                            val movie = Movie()
                            when {
                                i % 3 == 0 -> movie.setPosterPath("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/08/DSC02580.jpg")
                                i % 3 == 1 -> movie.setPosterPath("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/08/DSC02630.jpg")
                                else -> movie.setPosterPath("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/08/DSC02529.jpg")
                            }
                            movie.setTitle("Devil May Cry " + i)
                            movie.setOriginalTitle("Capcom")

                            listRowAdapter.add(movie)
                        }

                        // 2nd row: Display movie detail information and relative videos
                        mDetailOverviewRowPresenter?.initialState = FullWidthDetailsOverviewRowPresenter.STATE_SMALL

                        val classPresenterSelector = ClassPresenterSelector()
                        classPresenterSelector.addClassPresenter(DetailsOverviewRow::class.java, mDetailOverviewRowPresenter)
                        classPresenterSelector.addClassPresenter(ListRow::class.java, ListRowPresenter())

                        val adapter = ArrayObjectAdapter(classPresenterSelector)

                        // Add detail row into adapter
                        adapter.add(row)

                        // Add relative videos row into adapter
                        adapter.add(ListRow(headerItem, listRowAdapter))

                        // Bind adapter
                        setAdapter(adapter)
                    }

                    override fun onError(e: Throwable) {
                        activity.showToast(e.message as String)
                    }
                })
    }

    private fun createDetailRow(): Single<DetailsOverviewRow> =
            Single.create { emitter ->
                val row = DetailsOverviewRow(mSelectedMovie)
                loadImageBitmap(activity, mSelectedMovie?.getPosterPath(),
                        activity.convertDpToPixel(DETAIL_THUMB_WIDTH),
                        activity.convertDpToPixel(DETAIL_THUMB_HEIGHT),
                        row)

                emitter.onSuccess(row)
            }
}