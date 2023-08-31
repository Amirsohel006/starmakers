package com.starmakers.app.modules.campaignone.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class CampaignOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtKANTARA: String? = MyApp.getInstance().resources.getString(R.string.lbl_kantara3)
  ,
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
  var txtStoryline: String? = MyApp.getInstance().resources.getString(R.string.lbl_storyline)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.msg_in_1847_there)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAppxBudget: String? = MyApp.getInstance().resources.getString(R.string.lbl_appx_budget)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMovieStartDat: String? =
      MyApp.getInstance().resources.getString(R.string.msg_movie_start_dat)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMovieEndDate: String? =
      MyApp.getInstance().resources.getString(R.string.msg_movie_end_date)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtReleasingDate: String? =
      MyApp.getInstance().resources.getString(R.string.msg_releasing_date)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeZone: String? = MyApp.getInstance().resources.getString(R.string.lbl_cast)

)
