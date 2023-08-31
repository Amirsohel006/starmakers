package com.starmakers.app.modules.screenten.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ImageSliderSliderintrestonloanModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDonatemoneyto: String? =
      MyApp.getInstance().resources.getString(R.string.msg_donate_money_to)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDoremipsumdol: String? =
      MyApp.getInstance().resources.getString(R.string.msg_dorem_ipsum_dol)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var imageIntrestonloan: String? = ""

)
