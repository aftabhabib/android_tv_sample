package com.nambv.android_tv_sample.data.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by [Marcus Gabilheri](mailto:marcus@gabilheri.com)
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/8/16.
 */

class PaletteColors : Parcelable {
    private var toolbarBackgroundColor: Int = 0
    private var statusBarColor: Int = 0
    private var textColor: Int = 0
    private var titleColor: Int = 0

    fun getToolbarBackgroundColor(): Int {
        return toolbarBackgroundColor
    }

    fun setToolbarBackgroundColor(toolbarBackgroundColor: Int): PaletteColors {
        this.toolbarBackgroundColor = toolbarBackgroundColor
        return this
    }

    fun getStatusBarColor(): Int {
        return statusBarColor
    }

    fun setStatusBarColor(statusBarColor: Int): PaletteColors {
        this.statusBarColor = statusBarColor
        return this
    }

    fun getTextColor(): Int {
        return textColor
    }

    fun setTextColor(textColor: Int): PaletteColors {
        this.textColor = textColor
        return this
    }

    fun getTitleColor(): Int {
        return titleColor
    }

    fun setTitleColor(titleColor: Int): PaletteColors {
        this.titleColor = titleColor
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.toolbarBackgroundColor)
        dest.writeInt(this.statusBarColor)
        dest.writeInt(this.textColor)
        dest.writeInt(this.titleColor)
    }

    constructor()
    constructor(`in`: Parcel) {
        this.toolbarBackgroundColor = `in`.readInt()
        this.statusBarColor = `in`.readInt()
        this.textColor = `in`.readInt()
        this.titleColor = `in`.readInt()
    }

    companion object {

        val CREATOR: Parcelable.Creator<PaletteColors> = object : Parcelable.Creator<PaletteColors> {
            override fun createFromParcel(source: Parcel): PaletteColors {
                return PaletteColors(source)
            }

            override fun newArray(size: Int): Array<PaletteColors?> {
                return arrayOfNulls(size)
            }
        }
    }
}
