package com.starmakers.app.modules.auditionsthree.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class AuditionsThreeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDonationHistor: String? =
      MyApp.getInstance().resources.getString(R.string.msg_donation_histor)

)
