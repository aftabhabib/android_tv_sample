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

class Movie : Parcelable {

    private var id: String? = null

    @SerializedName("poster_path")
    private var posterPath: String? = null

    private var adult: Boolean = false
    private var overview: String? = null

    @SerializedName("release_date")
    private var releaseDate: String? = null

    @SerializedName("genre_ids")
    private var genreIds: List<String>? = null

    @SerializedName("original_title")
    private var originalTitle: String? = null

    @SerializedName("original_language")
    private var originalLanguage: String? = null

    private var title: String? = null

    @SerializedName("backdrop_path")
    private var backdropPath: String? = null

    private var popularity: Float = 0.toFloat()

    @SerializedName("vote_count")
    private var voteCount: Int = 0

    private var video: Boolean = false

    @SerializedName("vote_average")
    private var voteAverage: Float = 0.toFloat()

    constructor() {}

    fun getId(): String? {
        return id
    }

    fun setId(id: String): Movie {
        this.id = id
        return this
    }

    fun getPosterPath(): String? {
        return posterPath
    }

    fun setPosterPath(posterPath: String): Movie {
        this.posterPath = posterPath
        return this
    }

    fun isAdult(): Boolean {
        return adult
    }

    fun setAdult(adult: Boolean): Movie {
        this.adult = adult
        return this
    }

    fun getOverview(): String? {
        return overview
    }

    fun setOverview(overview: String): Movie {
        this.overview = overview
        return this
    }

    fun getReleaseDate(): String? {
        return releaseDate
    }

    fun setReleaseDate(releaseDate: String): Movie {
        this.releaseDate = releaseDate
        return this
    }

    fun getGenreIds(): List<String>? {
        return genreIds
    }

    fun setGenreIds(genreIds: List<String>): Movie {
        this.genreIds = genreIds
        return this
    }

    fun getOriginalTitle(): String? {
        return originalTitle
    }

    fun setOriginalTitle(originalTitle: String): Movie {
        this.originalTitle = originalTitle
        return this
    }

    fun getOriginalLanguage(): String? {
        return originalLanguage
    }

    fun setOriginalLanguage(originalLanguage: String): Movie {
        this.originalLanguage = originalLanguage
        return this
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String): Movie {
        this.title = title
        return this
    }

    fun getBackdropPath(): String? {
        return backdropPath
    }

    fun setBackdropPath(backdropPath: String): Movie {
        this.backdropPath = backdropPath
        return this
    }

    fun getPopularity(): Float {
        return popularity
    }

    fun setPopularity(popularity: Float): Movie {
        this.popularity = popularity
        return this
    }

    fun getVoteCount(): Int {
        return voteCount
    }

    fun setVoteCount(voteCount: Int): Movie {
        this.voteCount = voteCount
        return this
    }

    fun isVideo(): Boolean {
        return video
    }

    fun setVideo(video: Boolean): Movie {
        this.video = video
        return this
    }

    fun getVoteAverage(): Float {
        return voteAverage
    }

    fun setVoteAverage(voteAverage: Float): Movie {
        this.voteAverage = voteAverage
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.id)
        dest.writeString(this.posterPath)
        dest.writeByte(if (this.adult) 1.toByte() else 0.toByte())
        dest.writeString(this.overview)
        dest.writeString(this.releaseDate)
        dest.writeStringList(this.genreIds)
        dest.writeString(this.originalTitle)
        dest.writeString(this.originalLanguage)
        dest.writeString(this.title)
        dest.writeString(this.backdropPath)
        dest.writeFloat(this.popularity)
        dest.writeInt(this.voteCount)
        dest.writeByte(if (this.video) 1.toByte() else 0.toByte())
        dest.writeFloat(this.voteAverage)
    }

    protected constructor(`in`: Parcel) {
        this.id = `in`.readString()
        this.posterPath = `in`.readString()
        this.adult = `in`.readByte().toInt() != 0
        this.overview = `in`.readString()
        this.releaseDate = `in`.readString()
        this.genreIds = `in`.createStringArrayList()
        this.originalTitle = `in`.readString()
        this.originalLanguage = `in`.readString()
        this.title = `in`.readString()
        this.backdropPath = `in`.readString()
        this.popularity = `in`.readFloat()
        this.voteCount = `in`.readInt()
        this.video = `in`.readByte().toInt() != 0
        this.voteAverage = `in`.readFloat()
    }

    companion object {

        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie {
                return Movie(source)
            }

            override fun newArray(size: Int): Array<Movie?> {
                return arrayOfNulls(size)
            }
        }
    }
}
