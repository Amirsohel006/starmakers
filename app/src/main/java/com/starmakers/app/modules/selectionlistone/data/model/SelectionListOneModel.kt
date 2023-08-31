package com.starmakers.app.modules.selectionlistone.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class SelectionListOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAuditions: String? = MyApp.getInstance().resources.getString(R.string.lbl_auditions)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAuditionsOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_auditions)

)
