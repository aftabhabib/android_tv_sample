package com.nambv.android_tv_sample.details

import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter
import android.support.v17.leanback.widget.Presenter

/**
 * Presenter to demonstrate {@link FullWidthDetailsOverviewRowPresenter}
 */
class CustomFullWidthDetailsOverviewRowPresenter(presenter: Presenter) : FullWidthDetailsOverviewRowPresenter(presenter) {

    private val TAG = CustomFullWidthDetailsOverviewRowPresenter::class.java.simpleName

    override fun onLayoutOverviewFrame(viewHolder: ViewHolder?, oldState: Int, logoChanged: Boolean) {
        setState(viewHolder, FullWidthDetailsOverviewRowPresenter.STATE_HALF)
        super.onLayoutOverviewFrame(viewHolder, oldState, logoChanged)
    }
}