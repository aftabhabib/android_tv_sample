package com.nambv.android_tv_sample

import android.content.Context
import android.support.v17.leanback.widget.BaseCardView
import android.util.AttributeSet
import android.view.LayoutInflater

abstract class BindableCardView<T> : BaseCardView {

    constructor(context: Context?) : super(context) {
        initLayout()
    }

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs) {
        initLayout()
    }

    constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initLayout()
    }

    private fun initLayout() {
        isFocusable = true
        isFocusableInTouchMode = true
        val inflater = LayoutInflater.from(context)
        inflater.inflate(getLayoutResource(), this)
    }

    abstract fun bind(data: T)
    abstract fun getLayoutResource(): Int
}