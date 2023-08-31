package com.starmakers.app.modules.screennine.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ImageSliderSliderintrestonloanModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtBookArtists: String? = MyApp.getInstance().resources.getString(R.string.lbl_book_artists)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDoremipsumdol: String? =
      MyApp.getInstance().resources.getString(R.string.msg_dorem_ipsum_dol)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var imageIntrestonloan: String? = ""

)
