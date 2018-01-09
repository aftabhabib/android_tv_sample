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

class CastMember : Parcelable {

    private var id: Int = 0
    private var character: String? = null
    private var name: String? = null
    private var order: Int = 0

    @SerializedName("cast_id")
    private var castId: Int = 0

    @SerializedName("credit_id")
    private var creditId: String? = null

    @SerializedName("profile_path")
    private var profilePath: String? = null

    fun getId(): Int {
        return id
    }

    fun setId(id: Int): CastMember {
        this.id = id
        return this
    }

    fun getCastId(): Int {
        return castId
    }

    fun setCastId(castId: Int): CastMember {
        this.castId = castId
        return this
    }

    fun getCharacter(): String? {
        return character
    }

    fun setCharacter(character: String): CastMember {
        this.character = character
        return this
    }

    fun getCreditId(): String? {
        return creditId
    }

    fun setCreditId(creditId: String): CastMember {
        this.creditId = creditId
        return this
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String): CastMember {
        this.name = name
        return this
    }

    fun getOrder(): Int {
        return order
    }

    fun setOrder(order: Int): CastMember {
        this.order = order
        return this
    }

    fun getProfilePath(): String? {
        return profilePath
    }

    fun setProfilePath(profilePath: String): CastMember {
        this.profilePath = profilePath
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.id)
        dest.writeString(this.character)
        dest.writeString(this.name)
        dest.writeInt(this.order)
        dest.writeInt(this.castId)
        dest.writeString(this.creditId)
        dest.writeString(this.profilePath)
    }

    constructor()
    constructor(`in`: Parcel) {
        this.id = `in`.readInt()
        this.character = `in`.readString()
        this.name = `in`.readString()
        this.order = `in`.readInt()
        this.castId = `in`.readInt()
        this.creditId = `in`.readString()
        this.profilePath = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<CastMember> = object : Parcelable.Creator<CastMember> {
            override fun createFromParcel(source: Parcel): CastMember {
                return CastMember(source)
            }

            override fun newArray(size: Int): Array<CastMember?> {
                return arrayOfNulls(size)
            }
        }
    }
}
