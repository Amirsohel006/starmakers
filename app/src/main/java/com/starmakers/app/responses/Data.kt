package com.starmakers.app.responses

data class Data(
    val audition_date: String,
    val auditions_positions: List<AuditionsPosition>,
    val created_at: String,
    val id: Int,
    val movie_name: String,
    val movie_poster: String,
    val story_line: String,
    val timings_from: String,
    val timings_to: String,
    val updated_at: String,
    val venue: String
)