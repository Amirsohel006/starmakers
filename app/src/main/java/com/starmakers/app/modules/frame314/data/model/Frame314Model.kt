package com.starmakers.app.modules.frame314.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class Frame314Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtOnlyMembership: String? =
      MyApp.getInstance().resources.getString(R.string.msg_only_membership)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGohome: String? = MyApp.getInstance().resources.getString(R.string.lbl_go_home)

)
