package com.starmakers.app.modules.financialoverview.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class GridrectangletenRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtMovieKantara: String? = MyApp.getInstance().resources.getString(R.string.lbl_movie_kantara)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGenreMystery: String? = MyApp.getInstance().resources.getString(R.string.lbl_genre_mystery)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtViewDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_view_details)

)
