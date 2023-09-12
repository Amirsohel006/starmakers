package com.starmakers.app.responses

data class SelectionDetails(
    val id: Int,
    val auditions_positions: List<SelectionPosition>,
    val movie_poster: String,
    val movie_name: String,
    val audition_date: String,
    val timings_from: String,
    val timings_to: String,
    val venue: String,
    val story_line: String?, // Use the appropriate type if story_line is not a String
    val is_active: Boolean,
    val created_at: String,
    val updated_at: String
)