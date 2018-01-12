@file:JvmName("ExtensionsUtils")

package com.nambv.android_tv_sample.util

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import android.widget.Toast


/**
 * Returns the screen/display size
 */
fun Context.getDisplaySize(): Point {
    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size
}

/**
 * Shows a (long) toast
 */
fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

/**
 * Shows a (long) toast.
 */
fun Context.showToast(resourceId: Int) {
    Toast.makeText(this, getString(resourceId), Toast.LENGTH_LONG).show()
}

fun Context.convertDpToPixel(dp: Int): Int {
    val density = resources.displayMetrics.density
    return Math.round(dp.toFloat() * density)
}

/**
 * Formats time in milliseconds to hh:mm:ss string format.
 */
fun formatMillis(millis: Int): String {
    var millis = millis
    var result = ""
    val hr = millis / 3600000
    millis %= 3600000
    val min = millis / 60000
    millis %= 60000
    val sec = millis / 1000
    if (hr > 0) {
        result += hr.toString() + ":"
    }
    if (min >= 0) {
        result += if (min > 9) {
            min.toString() + ":"
        } else {
            "0$min:"
        }
    }

    result += if (sec > 9) {
        sec
    } else {
        "0" + sec
    }

    return result
}
