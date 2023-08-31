package com.starmakers.app.modules.selectionlistfour.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class Listrectangle140RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtChandru: String? = MyApp.getInstance().resources.getString(R.string.lbl_chandru)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYrsCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_23_yrs)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBangalore: String? = MyApp.getInstance().resources.getString(R.string.lbl_bangalore)

)
