package com.nambv.android_tv_sample.data.models

/**
 * Created by [Marcus Gabilheri](mailto:marcus@gabilheri.com)
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/9/16.
 */

class CreditsResponse {

    private var id: Int = 0
    private var cast: List<CastMember>? = null
    private var crew: List<CrewMember>? = null

    fun getId(): Int {
        return id
    }

    fun setId(id: Int): CreditsResponse {
        this.id = id
        return this
    }

    fun getCast(): List<CastMember>? {
        return cast
    }

    fun setCast(cast: List<CastMember>): CreditsResponse {
        this.cast = cast
        return this
    }

    fun getCrew(): List<CrewMember>? {
        return crew
    }

    fun setCrew(crew: List<CrewMember>): CreditsResponse {
        this.crew = crew
        return this
    }
}
