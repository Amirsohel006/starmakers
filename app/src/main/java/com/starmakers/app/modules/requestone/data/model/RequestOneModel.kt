package com.starmakers.app.modules.requestone.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class RequestOneModel(
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
  var txtSudeep: String? = MyApp.getInstance().resources.getString(R.string.lbl_sudeep)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtActor: String? = MyApp.getInstance().resources.getString(R.string.lbl_actor)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBangalore: String? = MyApp.getInstance().resources.getString(R.string.lbl_bangalore)

)
