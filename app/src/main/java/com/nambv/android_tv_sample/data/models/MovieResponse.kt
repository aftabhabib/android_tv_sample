package com.nambv.android_tv_sample.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by [Marcus Gabilheri](mailto:marcus@gabilheri.com)
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/8/16.
 */

class MovieResponse : Parcelable {

    private var page: Int = 0
    private var results: List<Movie>? = null

    @SerializedName("total_pages")
    private var totalPages: Int = 0

    @SerializedName("total_results")
    private var totalResults: Int = 0

    fun getPage(): Int {
        return page
    }

    fun setPage(page: Int): MovieResponse {
        this.page = page
        return this
    }

    fun getResults(): List<Movie>? {
        return results
    }

    fun setResults(results: List<Movie>): MovieResponse {
        this.results = results
        return this
    }

    fun getTotalPages(): Int {
        return totalPages
    }

    fun setTotalPages(totalPages: Int): MovieResponse {
        this.totalPages = totalPages
        return this
    }

    fun getTotalResults(): Int {
        return totalResults
    }

    fun setTotalResults(totalResults: Int): MovieResponse {
        this.totalResults = totalResults
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.page)
        dest.writeTypedList(this.results)
        dest.writeInt(this.totalPages)
        dest.writeInt(this.totalResults)
    }

    constructor()
    constructor(`in`: Parcel) {
        this.page = `in`.readInt()
        this.results = `in`.createTypedArrayList(Movie.CREATOR)
        this.totalPages = `in`.readInt()
        this.totalResults = `in`.readInt()
    }

    companion object {

        val CREATOR: Parcelable.Creator<MovieResponse> = object : Parcelable.Creator<MovieResponse> {
            override fun createFromParcel(source: Parcel): MovieResponse {
                return MovieResponse(source)
            }

            override fun newArray(size: Int): Array<MovieResponse?> {
                return arrayOfNulls(size)
            }
        }
    }
}
