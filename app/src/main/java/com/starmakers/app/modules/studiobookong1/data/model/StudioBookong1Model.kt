package com.starmakers.app.modules.studiobookong1.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class StudioBookong1Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtStudioBooking: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_studio_booking)

)
