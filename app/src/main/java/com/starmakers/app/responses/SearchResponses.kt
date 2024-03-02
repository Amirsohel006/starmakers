package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName

class SearchResponses {
    @SerializedName("artists"   ) var artists   : ArrayList<Artists>   = arrayListOf()
    @SerializedName("campaigns" ) var campaigns : ArrayList<Campaigns> = arrayListOf()
}


data class MoviePictures (

    @SerializedName("picture" ) var picture : String? = null

)


data class ArtistPictures (

    @SerializedName("artist_picture" ) var artistPicture : String? = null

)



data class Artists (

    @SerializedName("id"                  ) var id                : Int?                      = null,
    @SerializedName("email"               ) var email             : String?                   = null,
    @SerializedName("movie_pictures"      ) var moviePictures     : ArrayList<MoviePictures>  = arrayListOf(),
    @SerializedName("artist_pictures"     ) var artistPictures    : ArrayList<ArtistPictures> = arrayListOf(),
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
    @SerializedName("user"                ) var user              : Int?                      = null

)



data class Campaigns (

    @SerializedName("id"               ) var id             : Int?    = null,
    @SerializedName("campaigns_name"   ) var campaignsName  : String? = null,
    @SerializedName("genere"           ) var genere         : String? = null,
    @SerializedName("appx_budget"      ) var appxBudget     : String? = null,
    @SerializedName("movie_start_date" ) var movieStartDate : String? = null,
    @SerializedName("movie_start_end"  ) var movieStartEnd  : String? = null,
    @SerializedName("audition_date"    ) var auditionDate   : String? = null,
    @SerializedName("donation_return"  ) var donationReturn : String? = null,
    @SerializedName("one_line_story"   ) var oneLineStory   : String? = null,
    @SerializedName("movie_poster"     ) var moviePoster    : String? = null,
    @SerializedName("actor_picture_1"  ) var actorPicture1  : String? = null,
    @SerializedName("actor_picture_2"  ) var actorPicture2  : String? = null,
    @SerializedName("actor_picture_3"  ) var actorPicture3  : String? = null,
    @SerializedName("created_at"       ) var createdAt      : String? = null,
    @SerializedName("updated_at"       ) var updatedAt      : String? = null

)