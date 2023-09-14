package com.starmakers.app.responses

data class StudioRequests(
    val id: Int,
    val studio_picture: List<RequestStudioPicture>,
    val studio_name: String,
    val location: String,
    val budget: String,
    val studio_booking_date: String,
    val from_date: String,
    val to_date: String,
    val no_of_days: Int,
    val booking_studio: String,
    val studio: Int,
    val studio_bookiee: Int
)

data class RequestStudioPicture(
    val id: Int,
    val studio_picture: String,
    val studio: Int
)
