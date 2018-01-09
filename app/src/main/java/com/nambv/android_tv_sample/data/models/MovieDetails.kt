package com.nambv.android_tv_sample.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by [Marcus Gabilheri](mailto:marcus@gabilheri.com)
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/9/16.
 */

class MovieDetails : Parcelable {

    private var adult: Boolean = false
    private var overview: String? = null
    private var video: Boolean = false
    private var genres: List<Genre>? = null
    private var title: String? = null
    private var popularity: Float = 0.toFloat()
    private var budget: Int = 0
    private var runtime: Int = 0
    private var revenue: Int = 0
    private var tagline: String? = null
    private var status: String? = null

    @SerializedName("release_date")
    private var releaseDate: String? = null

    @SerializedName("poster_path")
    private var posterPath: String? = null

    @SerializedName("original_title")
    private var originalTitle: String? = null

    @SerializedName("original_language")
    private var originalLanguage: String? = null

    @SerializedName("backdrop_path")
    private var backdropPath: String? = null

    @SerializedName("vote_count")
    private var voteCount: Int = 0

    @SerializedName("vote_average")
    private var voteAverage: Float = 0.toFloat()

    @SerializedName("imdb_id")
    private var imdbId: String? = null

    private var paletteColors: PaletteColors? = null
    private var director: String? = null

    constructor() {}

    fun isAdult(): Boolean {
        return adult
    }

    fun setAdult(adult: Boolean): MovieDetails {
        this.adult = adult
        return this
    }

    fun getOverview(): String? {
        return overview
    }

    fun setOverview(overview: String): MovieDetails {
        this.overview = overview
        return this
    }

    fun isVideo(): Boolean {
        return video
    }

    fun setVideo(video: Boolean): MovieDetails {
        this.video = video
        return this
    }

    fun getGenres(): List<Genre>? {
        return genres
    }

    fun setGenres(genres: List<Genre>): MovieDetails {
        this.genres = genres
        return this
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String): MovieDetails {
        this.title = title
        return this
    }

    fun getPopularity(): Float {
        return popularity
    }

    fun setPopularity(popularity: Float): MovieDetails {
        this.popularity = popularity
        return this
    }

    fun getBudget(): Int {
        return budget
    }

    fun setBudget(budget: Int): MovieDetails {
        this.budget = budget
        return this
    }

    fun getRuntime(): Int {
        return runtime
    }

    fun setRuntime(runtime: Int): MovieDetails {
        this.runtime = runtime
        return this
    }

    fun getRevenue(): Int {
        return revenue
    }

    fun setRevenue(revenue: Int): MovieDetails {
        this.revenue = revenue
        return this
    }

    fun getTagline(): String? {
        return tagline
    }

    fun setTagline(tagline: String): MovieDetails {
        this.tagline = tagline
        return this
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String): MovieDetails {
        this.status = status
        return this
    }

    fun getReleaseDate(): String? {
        return releaseDate
    }

    fun setReleaseDate(releaseDate: String): MovieDetails {
        this.releaseDate = releaseDate
        return this
    }

    fun getPosterPath(): String? {
        return posterPath
    }

    fun setPosterPath(posterPath: String): MovieDetails {
        this.posterPath = posterPath
        return this
    }

    fun getOriginalTitle(): String? {
        return originalTitle
    }

    fun setOriginalTitle(originalTitle: String): MovieDetails {
        this.originalTitle = originalTitle
        return this
    }

    fun getOriginalLanguage(): String? {
        return originalLanguage
    }

    fun setOriginalLanguage(originalLanguage: String): MovieDetails {
        this.originalLanguage = originalLanguage
        return this
    }

    fun getBackdropPath(): String? {
        return backdropPath
    }

    fun setBackdropPath(backdropPath: String): MovieDetails {
        this.backdropPath = backdropPath
        return this
    }

    fun getVoteCount(): Int {
        return voteCount
    }

    fun setVoteCount(voteCount: Int): MovieDetails {
        this.voteCount = voteCount
        return this
    }

    fun getVoteAverage(): Float {
        return voteAverage
    }

    fun setVoteAverage(voteAverage: Float): MovieDetails {
        this.voteAverage = voteAverage
        return this
    }

    fun getImdbId(): String? {
        return imdbId
    }

    fun setImdbId(imdbId: String): MovieDetails {
        this.imdbId = imdbId
        return this
    }

    fun getPaletteColors(): PaletteColors? {
        return paletteColors
    }

    fun setPaletteColors(paletteColors: PaletteColors): MovieDetails {
        this.paletteColors = paletteColors
        return this
    }

    fun getDirector(): String? {
        return director
    }

    fun setDirector(director: String): MovieDetails {
        this.director = director
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeByte(if (this.adult) 1.toByte() else 0.toByte())
        dest.writeString(this.overview)
        dest.writeByte(if (this.video) 1.toByte() else 0.toByte())
        dest.writeTypedList(this.genres)
        dest.writeString(this.title)
        dest.writeFloat(this.popularity)
        dest.writeInt(this.budget)
        dest.writeInt(this.runtime)
        dest.writeInt(this.revenue)
        dest.writeString(this.tagline)
        dest.writeString(this.status)
        dest.writeString(this.releaseDate)
        dest.writeString(this.posterPath)
        dest.writeString(this.originalTitle)
        dest.writeString(this.originalLanguage)
        dest.writeString(this.backdropPath)
        dest.writeInt(this.voteCount)
        dest.writeFloat(this.voteAverage)
        dest.writeString(this.imdbId)
        dest.writeParcelable(this.paletteColors, flags)
        dest.writeString(this.director)
    }

    protected constructor(`in`: Parcel) {
        this.adult = `in`.readByte().toInt() != 0
        this.overview = `in`.readString()
        this.video = `in`.readByte().toInt() != 0
        this.genres = `in`.createTypedArrayList(Genre.CREATOR)
        this.title = `in`.readString()
        this.popularity = `in`.readFloat()
        this.budget = `in`.readInt()
        this.runtime = `in`.readInt()
        this.revenue = `in`.readInt()
        this.tagline = `in`.readString()
        this.status = `in`.readString()
        this.releaseDate = `in`.readString()
        this.posterPath = `in`.readString()
        this.originalTitle = `in`.readString()
        this.originalLanguage = `in`.readString()
        this.backdropPath = `in`.readString()
        this.voteCount = `in`.readInt()
        this.voteAverage = `in`.readFloat()
        this.imdbId = `in`.readString()
        this.paletteColors = `in`.readParcelable(PaletteColors::class.java.classLoader)
        this.director = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<MovieDetails> = object : Parcelable.Creator<MovieDetails> {
            override fun createFromParcel(source: Parcel): MovieDetails {
                return MovieDetails(source)
            }

            override fun newArray(size: Int): Array<MovieDetails?> {
                return arrayOfNulls(size)
            }
        }
    }
}
