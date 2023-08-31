package com.starmakers.app.modules.auditions.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class AuditionsRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDate: String? = MyApp.getInstance().resources.getString(R.string.lbl_date)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDateOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_26_05_2023)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_time)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_10am_12am)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVenue: String? = MyApp.getInstance().resources.getString(R.string.lbl_venue)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_gate_no_3_ba)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPosition: String? = MyApp.getInstance().resources.getString(R.string.lbl_position)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDancerActor: String? = MyApp.getInstance().resources.getString(R.string.lbl_dancer_actor)

)
