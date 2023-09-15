package com.starmakers.app.responses

data class ArtistRequestById(
    val artist_name: String,
    val location: String,
    val category_name: String,
    val artist_pictures: List<ArtistByPicture>,
    val artist: Int,
    val booking_status: String,
    val booking_date: String,
    val age:String,
    val height:String,
    val weight:String,
    val total_no_of_movies:String,
    val total_experience:String,
    val mobile_number:String
)


data class ArtistByPicture(
    val artist_picture: String
)
