package com.nambv.android_tv_sample.data.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by [Marcus Gabilheri](mailto:marcus@gabilheri.com)
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/9/16.
 */

class Genre : Parcelable {

    private var id: Int = 0
    private var name: String? = null


    fun getId(): Int {
        return id
    }

    fun setId(id: Int): Genre {
        this.id = id
        return this
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String): Genre {
        this.name = name
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.id)
        dest.writeString(this.name)
    }

    constructor()
    constructor(`in`: Parcel) {
        this.id = `in`.readInt()
        this.name = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<Genre> = object : Parcelable.Creator<Genre> {
            override fun createFromParcel(source: Parcel): Genre {
                return Genre(source)
            }

            override fun newArray(size: Int): Array<Genre?> {
                return arrayOfNulls(size)
            }
        }
    }
}
