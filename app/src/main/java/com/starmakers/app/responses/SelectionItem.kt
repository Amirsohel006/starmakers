package com.starmakers.app.responses

import com.google.gson.annotations.SerializedName


data class SelectionItem (

    @SerializedName("message" ) var message : String?         = null,
    @SerializedName("data"    ) var data1   : ArrayList<Data1> = arrayListOf()

)

data class AuditionsPositions (

    @SerializedName("id"                 ) var id                : Int?    = null,
    @SerializedName("audition_positions" ) var auditionPositions : String?  = null,
    @SerializedName("audition"           ) var audition          : Int?    = null

)


data class Audition1 (

    @SerializedName("id"                  ) var id                 : Int?                          = null,
    @SerializedName("auditions_positions" ) var auditionsPositions : ArrayList<AuditionsPositions> = arrayListOf(),
    @SerializedName("movie_poster"        ) var moviePoster        : String?                       = null,
    @SerializedName("movie_name"          ) var movieName          : String?                       = null,
    @SerializedName("audition_date"       ) var auditionDate       : String?                       = null,
    @SerializedName("timings_from"        ) var timingsFrom        : String?                       = null,
    @SerializedName("timings_to"          ) var timingsTo          : String?                       = null,
    @SerializedName("venue"               ) var venue              : String?                       = null,
    @SerializedName("story_line"          ) var storyLine          : String?                       = null,
    @SerializedName("is_active"           ) var isActive           : Boolean?                      = null,
    @SerializedName("created_at"          ) var createdAt          : String?                       = null,
    @SerializedName("updated_at"          ) var updatedAt          : String?                       = null

)

data class Data1 (

    @SerializedName("id"                ) var id               : Int?      = null,
    @SerializedName("audition"          ) var audition         : Audition1? = Audition1(),
    @SerializedName("applied_date"      ) var appliedDate      : String?   = null,
    @SerializedName("selection_status"  ) var selectionStatus  : String?   = null,
    @SerializedName("acting_picture_1"  ) var actingPicture1   : String?   = null,
    @SerializedName("acting_picture_2"  ) var actingPicture2   : String?   = null,
    @SerializedName("acting_picture_3"  ) var actingPicture3   : String?   = null,
    @SerializedName("acting_picture_4"  ) var actingPicture4   : String?   = null,
    @SerializedName("acting_picture_5"  ) var actingPicture5   : String?   = null,
    @SerializedName("acting_video_1"    ) var actingVideo1     : String?   = null,
    @SerializedName("acting_video_2"    ) var actingVideo2     : String?   = null,
    @SerializedName("created_at"        ) var createdAt        : String?   = null,
    @SerializedName("updated_at"        ) var updatedAt        : String?   = null,
    @SerializedName("artist"            ) var artist           : Int?      = null,
    @SerializedName("audition_position" ) var auditionPosition : Int?      = null

)
//data class SelectionItem(
//    val id: Int,
//    val audition: SelectionDetails,
//    val applied_date: String,
//    val selection_status: String,
//    val acting_picture_1: String,
//    val acting_picture_2: String,
//    val acting_picture_3: String,
//    val acting_picture_4: String,
//    val acting_picture_5: String,
//    val acting_video_1: String,
//    val acting_video_2: String,
//    val created_at: String,
//    val updated_at: String,
//    val artist: Int,
//    val audition_position: Int
//)
