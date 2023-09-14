package com.starmakers.app.responses

data class ArtistRequests(val artist_name: String,
                          val location: String,
                          val category_name: String,
                          val artist_pictures: List<ArtistPictureRequest>,
                          val artist: Int,
                          val booking_status: String,
                          val booking_date: String)

data class ArtistPictureRequest(
    val artist_picture: String
)
