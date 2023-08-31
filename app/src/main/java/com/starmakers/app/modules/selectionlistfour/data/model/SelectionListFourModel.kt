package com.starmakers.app.modules.selectionlistfour.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class SelectionListFourModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSelectionList: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_selection_list)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDancersSelecte: String? =
      MyApp.getInstance().resources.getString(R.string.msg_dancers_selecte)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMovie: String? = MyApp.getInstance().resources.getString(R.string.lbl_movie)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGenre: String? = MyApp.getInstance().resources.getString(R.string.lbl_genre)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDate: String? = MyApp.getInstance().resources.getString(R.string.lbl_date)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_time)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVenue: String? = MyApp.getInstance().resources.getString(R.string.lbl_venue)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRole: String? = MyApp.getInstance().resources.getString(R.string.lbl_role)

)
