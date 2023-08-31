package com.starmakers.app.modules.frame315.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class Frame315Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtRequestSentSu: String? =
      MyApp.getInstance().resources.getString(R.string.msg_request_sent_su)

)
