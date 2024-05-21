package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName

data class BookingResponseList(
    val status: String,
    @SerializedName("data")
    val data: BookingResponse
)

data class BookingResponse (
    @SerializedName("id"                  ) var id                : Int?                      = null,
    @SerializedName("movie_pictures"      ) var moviePictures     : ArrayList<BookingMoviePicture>  = arrayListOf(),
    @SerializedName("artist_pictures"     ) var artistPictures    : ArrayList<BookingArtistPicture> = arrayListOf(),
    @SerializedName("select_category"     ) var selectCategory    : String?                   = null,
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
    @SerializedName("created_at"          ) var createdAt         : String?                   = null,
    @SerializedName("updated_at"          ) var updatedAt         : String?                   = null,
    @SerializedName("user"                ) var user              : Int?                      = null,
    @SerializedName("booking_status")var bookingstatus : String?=null
)


data class BookingArtistPicture (
    @SerializedName("artist_picture" ) var artistPicture : String? = null
)

data class BookingMoviePicture (
    @SerializedName("picture" ) var picture : String? = null
)


