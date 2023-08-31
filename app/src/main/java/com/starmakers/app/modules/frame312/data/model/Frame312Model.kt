package com.starmakers.app.modules.frame312.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class Frame312Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtRequestSuccess: String? =
      MyApp.getInstance().resources.getString(R.string.msg_request_success)

)
