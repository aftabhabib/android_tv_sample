package com.nambv.android_tv_sample.error

import android.os.Bundle
import android.support.v17.leanback.app.ErrorFragment
import com.nambv.android_tv_sample.R

/*
 * This class demonstrates how to extend MainErrorFragment to create an error dialog.
 */
class MainErrorFragment : ErrorFragment() {

    companion object {
        const val TRANSLUCENT = true
        fun getInstance(): MainErrorFragment = MainErrorFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.app_name)
        setErrorContent()
    }

    private fun setErrorContent() {
        imageDrawable = activity.getDrawable(R.drawable.lb_ic_sad_cloud)
        message = getString(R.string.msg_error_fragment)
        setDefaultBackground(TRANSLUCENT)

        buttonText = getString(R.string.label_dismiss_error)
        setButtonClickListener {
            fragmentManager.beginTransaction().remove(this@MainErrorFragment).commit()
        }
    }
}
