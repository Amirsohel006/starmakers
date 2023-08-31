package com.starmakers.app.modules.screeneleven.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ScreenElevenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTakeOurMember: String? =
      MyApp.getInstance().resources.getString(R.string.msg_take_our_member)

)
