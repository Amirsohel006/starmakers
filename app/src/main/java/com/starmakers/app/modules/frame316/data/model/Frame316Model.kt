package com.starmakers.app.modules.frame316.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class Frame316Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtBookingDates: String? = MyApp.getInstance().resources.getString(R.string.lbl_booking_dates)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSelectFromDat: String? =
      MyApp.getInstance().resources.getString(R.string.msg_select_from_dat)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSelectToDate: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_select_to_date)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup150Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup151Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup151OneValue: String? = null
)
