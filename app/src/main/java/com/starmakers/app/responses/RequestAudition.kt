package com.starmakers.app.responses


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
    val weight:String

)


data class AuditionPosition(
    val id: Int,
    val audition_positions: String,
    val audition: Int
)
