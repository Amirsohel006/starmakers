package com.starmakers.app.modules.selectionlistthree.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class SelectionListThreeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtMyAuditions: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_auditions)

)
