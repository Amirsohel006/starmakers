package com.starmakers.app.modules.artistbookongtwo.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ArtistBookongTwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_artists)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMoviesActor: String? = MyApp.getInstance().resources.getString(R.string.msg_movies_actor)

)
