package com.nambv.android_tv_sample.error

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nambv.android_tv_sample.R

class ErrorActivity : Activity() {

    private lateinit var mErrorFragment: MainErrorFragment

    companion object {
        fun getInstance(context: Context) = Intent(context, ErrorActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testError()
    }

    private fun testError() {
        mErrorFragment = MainErrorFragment.getInstance()
        fragmentManager.beginTransaction().add(R.id.main_browse_fragment, mErrorFragment).commit()
    }
}
