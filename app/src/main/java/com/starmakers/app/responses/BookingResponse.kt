package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName

data class BookingResponseList(
    val status: String,
    @SerializedName("data")
    val data: BookingResponse
)

data class BookingResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("movie_pictures") val moviePictures: List<BookingMoviePicture>,
    @SerializedName("artist_pictures") val artistPictures: List<BookingArtistPicture>,
    @SerializedName("select_category") val selectCategory: String,
    @SerializedName("artist_name") val artistName: String,
    @SerializedName("mobile_number") val mobileNumber: String,
    val location: String,
    val age: Int,
    val height: String,
    val weight: String,
    @SerializedName("choose_acting_field") val chooseActingField: String,
    @SerializedName("total_no_of_movies") val totalNoOfMovies: Int,
    @SerializedName("total_experience") val totalExperience: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    val user: Int
)

data class BookingMoviePicture(val picture: String)

data class BookingArtistPicture(@SerializedName("artist_picture") val artistPicture: String)

