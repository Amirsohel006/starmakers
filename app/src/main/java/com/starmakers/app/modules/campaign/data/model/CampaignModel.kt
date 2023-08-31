package com.starmakers.app.modules.campaign.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class CampaignModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtKANTARA: String? = MyApp.getInstance().resources.getString(R.string.lbl_kantara2)

)
