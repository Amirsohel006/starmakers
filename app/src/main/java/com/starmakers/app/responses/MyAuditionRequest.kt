package com.starmakers.app.responses

data class MyAuditionRequest(
    val id: Int,
    val artist: Artist,
    val audition_name: String,
    val movie_poster: String,
    val audition_date: String,
    val venue: String,
    val movie_name: String,
    val timings_from: String,
    val applied_date: String,
    val audition_positions: String,
    val audition_ID:String
)

data class Artist(
    val id: Int,
    val name: String,
    val age: String,
    val height: String,
    val weight: String,
    val profile: String,
    val location: String
)
