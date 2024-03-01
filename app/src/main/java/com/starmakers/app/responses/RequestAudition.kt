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
   var artist_name        : String?                   = null,
    var id                : Int?                      = null,
   var movie_pictures     : ArrayList<String>         = arrayListOf(),
  var artist_pictures    : ArrayList<artist_pictures> = arrayListOf(),
 var choose_acting_field : String?                   = null,
 var total_no_of_movies   : Int?                      = null,
 var total_experience   : String?                   = null,
 var is_booked          : Boolean?                  = null,
 var is_member          : Boolean?                  = null,
 var user              : Int?                      = null,
  var location          : String?                   = null,
)





data class artist_pictures (

    @SerializedName("artist_picture" ) var artist_picture : String? = null

)
data class AuditionPosition(
    val id: Int,
    val audition_positions: String,
    val audition: Int
)
