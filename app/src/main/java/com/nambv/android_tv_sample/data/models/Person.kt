package com.nambv.android_tv_sample.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by [Marcus Gabilheri](mailto:marcus@gabilheri.com)
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/10/16.
 */

class Person : Parcelable {

    private var id: Int = 0
    private var biography: String? = null
    private var birthday: String? = null
    private var deathday: String? = null
    private var gender: Int = 0
    private var homepage: String? = null
    private var name: String? = null
    private var popularity: Float = 0.toFloat()
    private var adult: Boolean = false

    @SerializedName("profile_path")
    private var profilePath: String? = null

    @SerializedName("place_of_birth")
    private var placeOfBirth: String? = null

    constructor() {}

    fun getId(): Int {
        return id
    }

    fun setId(id: Int): Person {
        this.id = id
        return this
    }

    fun getBiography(): String? {
        return biography
    }

    fun setBiography(biography: String): Person {
        this.biography = biography
        return this
    }

    fun getBirthday(): String? {
        return birthday
    }

    fun setBirthday(birthday: String): Person {
        this.birthday = birthday
        return this
    }

    fun getDeathday(): String? {
        return deathday
    }

    fun setDeathday(deathday: String): Person {
        this.deathday = deathday
        return this
    }

    fun getGender(): Int {
        return gender
    }

    fun setGender(gender: Int): Person {
        this.gender = gender
        return this
    }

    fun getHomepage(): String? {
        return homepage
    }

    fun setHomepage(homepage: String): Person {
        this.homepage = homepage
        return this
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String): Person {
        this.name = name
        return this
    }

    fun getPopularity(): Float {
        return popularity
    }

    fun setPopularity(popularity: Float): Person {
        this.popularity = popularity
        return this
    }

    fun isAdult(): Boolean {
        return adult
    }

    fun setAdult(adult: Boolean): Person {
        this.adult = adult
        return this
    }

    fun getProfilePath(): String? {
        return profilePath
    }

    fun setProfilePath(profilePath: String): Person {
        this.profilePath = profilePath
        return this
    }

    fun getPlaceOfBirth(): String? {
        return placeOfBirth
    }

    fun setPlaceOfBirth(placeOfBirth: String): Person {
        this.placeOfBirth = placeOfBirth
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.id)
        dest.writeString(this.biography)
        dest.writeString(this.birthday)
        dest.writeString(this.deathday)
        dest.writeInt(this.gender)
        dest.writeString(this.homepage)
        dest.writeString(this.name)
        dest.writeFloat(this.popularity)
        dest.writeByte(if (this.adult) 1.toByte() else 0.toByte())
        dest.writeString(this.profilePath)
        dest.writeString(this.placeOfBirth)
    }

    constructor(`in`: Parcel) {
        this.id = `in`.readInt()
        this.biography = `in`.readString()
        this.birthday = `in`.readString()
        this.deathday = `in`.readString()
        this.gender = `in`.readInt()
        this.homepage = `in`.readString()
        this.name = `in`.readString()
        this.popularity = `in`.readFloat()
        this.adult = `in`.readByte().toInt() != 0
        this.profilePath = `in`.readString()
        this.placeOfBirth = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<Person> = object : Parcelable.Creator<Person> {
            override fun createFromParcel(source: Parcel): Person {
                return Person(source)
            }

            override fun newArray(size: Int): Array<Person?> {
                return arrayOfNulls(size)
            }
        }
    }
}
