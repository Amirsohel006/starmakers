package com.starmakers.app.responses

data class EditingStudioData(
    val message: String,
    val data: List<EditingStudio>
)

data class EditingStudio(
    val id: Int,
    val studio_picture: List<EditingStudioPicture>,
    val studio_movie: List<EditingStudioMovie>,
    val studio_booking: List<Any>, // You can replace with an appropriate type
    val studio_name: String,
    val location: String,
    val date_of_start: String,
    val budget: Int,
    val owner: String,
    val owner_number: String,
    val total_no_of_movies: Int,
    val write_about_studio: String,
    val select_studio_type: String,
    val created_at: String,
    val updated_at: String
)

data class EditingStudioPicture(
    val id: Int,
    val studio_picture: String,
    val studio: Int
)

data class EditingStudioMovie(
    val id: Int,
    val studio_movie: String,
    val studio: Int
)

