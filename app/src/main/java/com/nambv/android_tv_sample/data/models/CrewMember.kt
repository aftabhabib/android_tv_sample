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

class CrewMember : Parcelable {

    private var id: Int = 0
    private var job: String? = null
    private var name: String? = null
    private var department: String? = null

    @SerializedName("profile_path")
    private var profilePath: String? = null

    constructor() {}

    fun getId(): Int {
        return id
    }

    fun setId(id: Int): CrewMember {
        this.id = id
        return this
    }

    fun getJob(): String? {
        return job
    }

    fun setJob(job: String): CrewMember {
        this.job = job
        return this
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String): CrewMember {
        this.name = name
        return this
    }

    fun getDepartment(): String? {
        return department
    }

    fun setDepartment(department: String): CrewMember {
        this.department = department
        return this
    }

    fun getProfilePath(): String? {
        return profilePath
    }

    fun setProfilePath(profilePath: String): CrewMember {
        this.profilePath = profilePath
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.id)
        dest.writeString(this.job)
        dest.writeString(this.name)
        dest.writeString(this.department)
        dest.writeString(this.profilePath)
    }

    constructor(`in`: Parcel) {
        this.id = `in`.readInt()
        this.job = `in`.readString()
        this.name = `in`.readString()
        this.department = `in`.readString()
        this.profilePath = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<CrewMember> = object : Parcelable.Creator<CrewMember> {
            override fun createFromParcel(source: Parcel): CrewMember {
                return CrewMember(source)
            }

            override fun newArray(size: Int): Array<CrewMember?> {
                return arrayOfNulls(size)
            }
        }
    }
}
