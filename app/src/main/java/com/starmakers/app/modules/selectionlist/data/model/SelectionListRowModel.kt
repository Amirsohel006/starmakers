package com.starmakers.app.modules.selectionlist.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class SelectionListRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtChecktheselec: String? =
      MyApp.getInstance().resources.getString(R.string.msg_check_the_selec)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtChecktheselecOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_check_the_selec)

)
