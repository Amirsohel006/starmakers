package com.starmakers.app.modules.screeneight.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ScreenEightModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDirectStudioB: String? =
      MyApp.getInstance().resources.getString(R.string.msg_direct_studio_b)
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
  var txtSkip: String? = MyApp.getInstance().resources.getString(R.string.lbl_skip)

)
