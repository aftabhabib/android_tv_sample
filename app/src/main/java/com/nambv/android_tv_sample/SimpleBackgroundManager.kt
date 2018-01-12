package com.nambv.android_tv_sample

import android.app.Activity
import android.graphics.drawable.Drawable
import android.support.v17.leanback.app.BackgroundManager
import android.util.DisplayMetrics
import java.util.*


class SimpleBackgroundManager(mActivity: Activity) {

    private val DEFAULT_BACKGROUND_RES_ID = R.drawable.default_background
    private val mBackgroundManager: BackgroundManager
    private var mBackgroundTimer: Timer? = null
    private var mUrl: String = ""

    init {
        mDefaultBackground = mActivity.getDrawable(DEFAULT_BACKGROUND_RES_ID)
        mBackgroundManager = BackgroundManager.getInstance(mActivity)
        mBackgroundManager.attach(mActivity.window)
        mActivity.windowManager.defaultDisplay.getMetrics(DisplayMetrics())
    }

    fun updateBackground(drawable: Drawable) {
        mBackgroundManager.drawable = drawable
    }

    fun clearBackground() {
        mBackgroundManager.drawable = mDefaultBackground
    }

    companion object {

        private val TAG = SimpleBackgroundManager::class.java.simpleName
        private var mDefaultBackground: Drawable? = null
    }
}
