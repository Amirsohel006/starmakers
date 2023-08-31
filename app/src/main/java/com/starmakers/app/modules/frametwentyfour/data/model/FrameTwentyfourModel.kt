package com.starmakers.app.modules.frametwentyfour.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class FrameTwentyfourModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRegistrationSu: String? =
      MyApp.getInstance().resources.getString(R.string.msg_registration_su)

)
