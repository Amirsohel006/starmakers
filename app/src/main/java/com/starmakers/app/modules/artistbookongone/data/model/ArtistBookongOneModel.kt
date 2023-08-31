package com.starmakers.app.modules.artistbookongone.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ArtistBookongOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtProfile: String? = MyApp.getInstance().resources.getString(R.string.lbl_profile)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAddProfile: String? = MyApp.getInstance().resources.getString(R.string.lbl_add_profile)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup149Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup153Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup150Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup151Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup152Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup487Value: String? = null
)
