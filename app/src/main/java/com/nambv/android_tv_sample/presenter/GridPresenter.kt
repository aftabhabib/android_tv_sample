package com.nambv.android_tv_sample.presenter

import android.graphics.Color
import android.support.v17.leanback.widget.Presenter
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import com.nambv.android_tv_sample.R

class GridItemPresenter : Presenter() {

    companion object {
        const val GRID_ITEM_WIDTH = 300
        const val GRID_ITEM_HEIGHT = 200
    }

    override fun onCreateViewHolder(parent: ViewGroup): Presenter.ViewHolder {
        val textView = TextView(parent.context)
        textView.layoutParams = ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT)
        textView.isFocusable = true
        textView.isFocusableInTouchMode = true
        textView.setBackgroundColor(ContextCompat.getColor(parent.context, R.color.default_background))
        textView.setTextColor(Color.WHITE)
        textView.gravity = Gravity.CENTER

        return Presenter.ViewHolder(textView)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) {
        (viewHolder.view as TextView).text = item as String
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) = Unit
}

