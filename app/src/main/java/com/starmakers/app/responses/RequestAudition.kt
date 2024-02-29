package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName


data class RequestAudition(  val status: String,
                             val data: RequestUserData,

)
data class RequestUserData(
    val name: String,
    val email: String,
    val mobile_number: String,
    val city: String,
    val pin_code: String,
    val profile: String,
    val age:String,
    val height:String,
    val weight:String,
    @SerializedName("artist_name"         ) var artistName        : String?                   = null,
    @SerializedName("id"                  ) var id                : Int?                      = null,
    @SerializedName("movie_pictures"      ) var moviePictures     : ArrayList<String>         = arrayListOf(),
    @SerializedName("artist_pictures"     ) var artistPictures    : ArrayList<ArtistPictures> = arrayListOf(),
    @SerializedName("mobile_number"       ) var phoneNumber      : String?                   = null,
    @SerializedName("choose_acting_field" ) var chooseActingField : String?                   = null,
@SerializedName("total_no_of_movies"  ) var totalNoOfMovies   : Int?                      = null,
@SerializedName("total_experience"    ) var totalExperience   : String?                   = null,
@SerializedName("is_booked"           ) var isBooked          : Boolean?                  = null,
@SerializedName("is_member"           ) var isMember          : Boolean?                  = null,
@SerializedName("created_at"          ) var createdAt         : String?                   = null,
@SerializedName("updated_at"          ) var updatedAt         : String?                   = null,
@SerializedName("user"                ) var user              : Int?                      = null,
    @SerializedName("location"            ) var location          : String?                   = null,
)





data class ArtistPictures (

    @SerializedName("artist_picture" ) var artistPicture : String? = null

)
data class AuditionPosition(
    val id: Int,
    val audition_positions: String,
    val audition: Int
)
