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

data class Movie(

        private var id: String? = null,
        @SerializedName("poster_path")
        private var posterPath: String? = null,
        private var adult: Boolean = false,
        private var overview: String? = null,
        @SerializedName("release_date")
        private var releaseDate: String? = null,

        @SerializedName("genre_ids")
        private var genreIds: List<String>? = null,

        @SerializedName("original_title")
        private var originalTitle: String? = null,

        @SerializedName("original_language")
        private var originalLanguage: String? = null,

        private var title: String? = null,

        @SerializedName("backdrop_path")
        private var backdropPath: String? = null,

        private var popularity: Float = 0.toFloat(),

        @SerializedName("vote_count")
        private var voteCount: Int = 0,

        private var video: Boolean = false,

        @SerializedName("vote_average")
        private var voteAverage: Float = 0.toFloat()) : Parcelable {
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

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            1 == source.readInt(),
            source.readString(),
            source.readString(),
            source.createStringArrayList(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readFloat(),
            source.readInt(),
            1 == source.readInt(),
            source.readFloat()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(posterPath)
        writeInt((if (adult) 1 else 0))
        writeString(overview)
        writeString(releaseDate)
        writeStringList(genreIds)
        writeString(originalTitle)
        writeString(originalLanguage)
        writeString(title)
        writeString(backdropPath)
        writeFloat(popularity)
        writeInt(voteCount)
        writeInt((if (video) 1 else 0))
        writeFloat(voteAverage)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie = Movie(source)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }
}
