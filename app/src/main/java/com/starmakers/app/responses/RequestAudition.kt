package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName


data class RequestAudition(  val status: String,
                             val data: RequestUserData,

)
data class RequestUserData(
    @SerializedName("id"                  ) var id                : Int?                      = null,
    @SerializedName("email"               ) var email             : String?                   = null,
    @SerializedName("city"                ) var city              : String?                   = null,
    @SerializedName("movie_pictures"      ) var moviePictures     : ArrayList<RequestMoviePictures>  = arrayListOf(),
    @SerializedName("artist_pictures"     ) var artistPictures    : ArrayList<RequestArtistPictures> = arrayListOf(),
    @SerializedName("select_category"     ) var selectCategory    : String?                   = null,
    @SerializedName("booking_status"      ) var bookingStatus     : String?                   = null,
    @SerializedName("artist_name"         ) var artistName        : String?                   = null,
    @SerializedName("mobile_number"       ) var mobileNumber      : String?                   = null,
    @SerializedName("location"            ) var location          : String?                   = null,
    @SerializedName("age"                 ) var age               : Int?                      = null,
    @SerializedName("height"              ) var height            : String?                   = null,
    @SerializedName("weight"              ) var weight            : String?                   = null,
    @SerializedName("choose_acting_field" ) var chooseActingField : String?                   = null,
    @SerializedName("total_no_of_movies"  ) var totalNoOfMovies   : Int?                      = null,
    @SerializedName("total_experience"    ) var totalExperience   : String?                   = null,
    @SerializedName("is_booked"           ) var isBooked          : Boolean?                  = null,
    @SerializedName("is_member"           ) var isMember          : Boolean?                  = null,
    @SerializedName("created_at"          ) var createdAt         : String?                   = null,
    @SerializedName("updated_at"          ) var updatedAt         : String?                   = null,
    @SerializedName("user"                ) var user              : Int?                      = null,
    @SerializedName("profile"             ) var profile           : String?                   = null,
    @SerializedName("name")var name:String?=null
)


data class RequestMoviePictures (

    @SerializedName("picture" ) var picture : String? = null

)



data class RequestArtistPictures (

    @SerializedName("artist_picture" ) var artistPicture : String? = null

)
data class AuditionPosition(
    val id: Int,
    val audition_positions: String,
    val audition: Int
)
