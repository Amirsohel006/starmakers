package com.starmakers.app.responses

data class MyStudioRequest(
    val status: String,
    val data: StudioInfo
)

data class StudioInfo(
    val id: Int,
    val studio_picture: List<MyStudioPicture>,
    val studio_movie: List<MyStudioMovie>,  // Assuming this can be a list of some data class
    val studio_booking: List<MyStudioBooking>,
    val studio_name: String,
    val location: String,
    val date_of_start: String,  // You may want to use a Date type here
    val budget: Int,
    val owner: String,
    val owner_number: String,
    val total_no_of_movies: Int,
    val write_about_studio: String,
    val select_studio_type: String,
    val created_at: String,  // You may want to use a Date type here
    val updated_at: String  // You may want to use a Date type here
)

data class MyStudioPicture(
    val id: Int,
    val studio_picture: String,
    val studio: Int
)

data class MyStudioBooking(
    val id: Int,
    val studio_booking_date: String,  // You may want to use a Date type here
    val from_date: String,  // You may want to use a Date type here
    val to_date: String,  // You may want to use a Date type here
    val no_of_days: Int,
    val booking_studio: String,
    val studio: Int,
    val studio_bookiee: Int
)



data class MyStudioMovie(
    val id:Int,
    val studio_movie:String,
    val studio: Int
)
