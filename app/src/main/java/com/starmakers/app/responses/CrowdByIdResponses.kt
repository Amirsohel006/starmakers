package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName

data class CrowdByIdResponses(
    @SerializedName("status"        ) var status       : String?       = null,
    @SerializedName("campaign_data" ) var campaignData : CrowByIdData? = CrowByIdData(),
    @SerializedName("finance_data"  ) var financeData  : FinanceData?  = FinanceData()
)


data class CrowByIdData (

    @SerializedName("id"               ) var id             : Int?    = null,
    @SerializedName("campaigns_name"   ) var campaignsName  : String? = null,
    @SerializedName("genere"           ) var genere         : String? = null,
    @SerializedName("appx_budget"      ) var appxBudget     : String? = null,
    @SerializedName("movie_start_date" ) var movieStartDate : String? = null,
    @SerializedName("movie_start_end"  ) var movieStartEnd  : String? = null,
    @SerializedName("audition_date"    ) var auditionDate   : String? = null,
    @SerializedName("donation_return"  ) var donationReturn : String? = null,
    @SerializedName("one_line_story"   ) var oneLineStory   : String? = null,
    @SerializedName("movie_poster"     ) var moviePoster    : String? = null,
    @SerializedName("actor_picture_1"  ) var actorPicture1  : String? = null,
    @SerializedName("actor_picture_2"  ) var actorPicture2  : String? = null,
    @SerializedName("actor_picture_3"  ) var actorPicture3  : String? = null,
    @SerializedName("created_at"       ) var createdAt      : String? = null,
    @SerializedName("updated_at"       ) var updatedAt      : String? = null

)