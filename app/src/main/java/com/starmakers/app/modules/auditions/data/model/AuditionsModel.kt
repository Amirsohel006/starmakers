package com.starmakers.app.modules.auditions.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class AuditionsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAuditions: String? = MyApp.getInstance().resources.getString(R.string.lbl_auditions)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSelectionList: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_selection_list)

)
