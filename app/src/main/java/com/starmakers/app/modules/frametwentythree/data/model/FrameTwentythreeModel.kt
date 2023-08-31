package com.starmakers.app.modules.frametwentythree.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class FrameTwentythreeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtParticipationS: String? =
      MyApp.getInstance().resources.getString(R.string.msg_participation_s)

)
