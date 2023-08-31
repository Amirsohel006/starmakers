package com.starmakers.app.modules.home.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class HomeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRahul: String? = MyApp.getInstance().resources.getString(R.string.lbl_rahul)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtArtistMembersh: String? =
      MyApp.getInstance().resources.getString(R.string.msg_artist_members)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtArtistBooking: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_artist_booking)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAuditions: String? = MyApp.getInstance().resources.getString(R.string.lbl_auditions)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStudioBookings: String? =
      MyApp.getInstance().resources.getString(R.string.msg_studio_booking)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCrowdFundingZ: String? =
      MyApp.getInstance().resources.getString(R.string.msg_crowd_funding_z)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFundingDemoVi: String? =
      MyApp.getInstance().resources.getString(R.string.msg_funding_demo_vi)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDonatorExperie: String? =
      MyApp.getInstance().resources.getString(R.string.msg_donator_experie)

)
