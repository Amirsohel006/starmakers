package com.starmakers.app.responses

data class SelectionItem(
    val id: Int,
    val audition: SelectionDetails,
    val applied_date: String,
    val selection_status: String,
    val acting_picture_1: String,
    val acting_picture_2: String,
    val acting_picture_3: String,
    val acting_picture_4: String,
    val acting_picture_5: String,
    val acting_video_1: String,
    val acting_video_2: String,
    val created_at: String,
    val updated_at: String,
    val artist: Int,
    val audition_position: Int
)
