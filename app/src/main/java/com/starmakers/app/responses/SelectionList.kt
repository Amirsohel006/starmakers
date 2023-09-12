package com.starmakers.app.responses

data class SelectionListResponse(
    var message: String,
    val data: List<SelectionListItem>
)

data class SelectionListItem(
    val artist: SelectionListArtist,
    val audition_name: String,
    val movie_poster: String,
    val audition_date: String,
    val venue: String,
    val movie_name: String,
    val timings_from: String,
    val applied_date: String,
    val audition_position: Int?
)

data class SelectionListArtist(
    val artist_name: String?, // Use the appropriate data type based on your actual data
    val age: String? // Use the appropriate data type based on your actual data
)

