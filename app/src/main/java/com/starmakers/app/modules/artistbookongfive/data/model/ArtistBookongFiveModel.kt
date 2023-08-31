package com.starmakers.app.modules.artistbookongfive.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ArtistBookongFiveModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_artist_booking2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtArtistBooking: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_artist_booking3)

)
