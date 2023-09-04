package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse( @SerializedName("token")
                          val access_token: String,
                          val message: String,
                          @SerializedName("refresh")
                          val refresh: String,
                          val user_id: Int,
                          val otp:String)
data class SignUpResponse(
    val name:String,
    val mobile_number:String,
    val email:String,
    val city:String,
    val pin_code:String,
    val profile:String
)


data class ProfileResponse(
  val artist_name:String,
    val mobile_number:String,
    val location:String,
    val age:String,
    val email:String,
    val height:String,
    val weight:String,
    val choose_acting_field:String,
    val total_no_of_movies:String,
    val total_experience:String,
    val created_at:String,
    val updated_at:String,
    val user:Int,
    val profile:String
)