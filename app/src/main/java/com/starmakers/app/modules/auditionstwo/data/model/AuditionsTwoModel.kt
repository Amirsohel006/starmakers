package com.starmakers.app.modules.auditionstwo.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class AuditionsTwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRamamandStudio: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_ramamand_studio)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtName: String? = MyApp.getInstance().resources.getString(R.string.lbl_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYear: String? = MyApp.getInstance().resources.getString(R.string.lbl_year)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAbout: String? = MyApp.getInstance().resources.getString(R.string.lbl_about)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_lorem_ipsum_dol2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMovies: String? = MyApp.getInstance().resources.getString(R.string.lbl_movies2)

)
