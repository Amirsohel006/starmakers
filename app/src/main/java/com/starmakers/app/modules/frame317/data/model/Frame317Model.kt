package com.starmakers.app.modules.frame317.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class Frame317Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtDonationSucces: String? =
      MyApp.getInstance().resources.getString(R.string.msg_donation_succes)

)
