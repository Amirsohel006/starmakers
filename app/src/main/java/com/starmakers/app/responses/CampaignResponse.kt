package com.starmakers.app.responses

data class CampaignResponse(
    val status: String,
    val data: List<Campaign>
)

data class Campaign(
    val id: Int,
    val campaigns_name: String,
    val genere: String,
    val appx_budget: String,
    val movie_start_date: String?,
    val movie_start_end: String?,
    val audition_date: String,
    val donation_return: String,
    val one_line_story: String,
    val movie_poster: String?,
    val actor_picture_1: String?,
    val actor_picture_2: String?,
    val actor_picture_3: String?,
    val created_at: String,
    val updated_at: String
)
