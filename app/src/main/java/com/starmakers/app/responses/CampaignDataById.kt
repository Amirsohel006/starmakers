package com.starmakers.app.responses

data class CampaignDataById(
    val status: String,
    val data: CampaignInfo
)

data class CampaignInfo(
    val id: Int,
    val campaign_name: String,
    val genere:String,
    val one_line_story:String,
    val movie_poster: String?, // This can be a nullable String if it can be null
    val appx_budget: String,
    val collected_budget_amount: String,
    val spent_amount: String,
    val required_additional_budget: String,
    val total_spent_amount: String,
    val above_the_budget_amount: String,
    val below_the_budget_amount: String,
    val share_amount: String,
    val available_amount: String,
    val created_at: String, // You may want to use a Date type here
    val updated_at: String, // You may want to use a Date type here
    val campaign: Int,
    val audition_date:String
)
