package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName

data class SelectionListResponse (

    @SerializedName("message" ) var message : String?         = null,
    @SerializedName("data"    ) var data    : ArrayList<SelectionListItem> = arrayListOf()

)


data class SelectionListItem (

    @SerializedName("artist"             ) var artist            : SelectionListArtist? = SelectionListArtist(),
    @SerializedName("audition_name"      ) var auditionName      : String? = null,
    @SerializedName("movie_poster"       ) var moviePoster       : String? = null,
    @SerializedName("audition_date"      ) var auditionDate      : String? = null,
    @SerializedName("venue"              ) var venue             : String? = null,
    @SerializedName("movie_name"         ) var movieName         : String? = null,
    @SerializedName("timings_from"       ) var timingsFrom       : String? = null,
    @SerializedName("applied_date"       ) var appliedDate       : String? = null,
    @SerializedName("audition_positions" ) var auditionPositions : String? = null

)


data class SelectionListArtist (

    @SerializedName("name"    ) var name    : String? = null,
    @SerializedName("age"     ) var age     : String? = null,
    @SerializedName("profile" ) var profile : String? = null

)

