package com.starmakers.app.modules.activities.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ActivitiesModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRahul: String? = MyApp.getInstance().resources.getString(R.string.lbl_rahul)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtActivities: String? = MyApp.getInstance().resources.getString(R.string.lbl_activities)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyRequests: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_requests)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOne: String? = MyApp.getInstance().resources.getString(R.string.lbl)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyAuditions: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_auditions)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStudiosBooked: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_studios_booked)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRamanandStudio: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_ramanand_studio)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLocationJPN: String? = MyApp.getInstance().resources.getString(R.string.msg_location_jp_n)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMeasurement: String? = MyApp.getInstance().resources.getString(R.string.lbl_cost_24l)

)
