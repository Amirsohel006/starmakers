package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName

data class BannerResponses(
    @SerializedName("id"         ) var id        : Int?    = null,
    @SerializedName("image"      ) var image     : String? = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null
)
