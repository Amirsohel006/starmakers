package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName

data class BudgetResponse(
    @SerializedName("campaign_name" ) var campaignName : String? = null,
    @SerializedName("genere"        ) var genere       : String? = null,
    @SerializedName("appx_budget"   ) var appxBudget   : String? = null,
    @SerializedName("amount"        ) var amount       : String? = null,
    @SerializedName("movie_poster")  var moviePoster:String?=null
)
