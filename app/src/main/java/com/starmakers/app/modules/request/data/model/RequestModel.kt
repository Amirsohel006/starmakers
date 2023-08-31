package com.starmakers.app.modules.request.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class RequestModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRequests: String? = MyApp.getInstance().resources.getString(R.string.lbl_requests)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtArtistRequests: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_artist_requests)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStudioRequests: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_studio_requests)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRamanandStudio: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_ramanand_studio)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLocationJPN: String? = MyApp.getInstance().resources.getString(R.string.msg_location_jp_n)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMeasurement: String? = MyApp.getInstance().resources.getString(R.string.lbl_cost_24l)

)
