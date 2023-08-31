package com.starmakers.app.modules.search.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class SearchModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRecentSearches: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_recent_searches)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRajkumara: String? = MyApp.getInstance().resources.getString(R.string.lbl_rajkumara)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtKantara: String? = MyApp.getInstance().resources.getString(R.string.lbl_kantara)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRobert: String? = MyApp.getInstance().resources.getString(R.string.lbl_robert)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPopularSearch: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_popular_search)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDarshan: String? = MyApp.getInstance().resources.getString(R.string.lbl_darshan)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAuditions: String? = MyApp.getInstance().resources.getString(R.string.lbl_auditions)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSuryatej: String? = MyApp.getInstance().resources.getString(R.string.lbl_suryatej)

)
