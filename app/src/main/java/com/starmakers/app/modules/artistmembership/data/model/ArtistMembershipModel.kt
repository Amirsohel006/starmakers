package com.starmakers.app.modules.artistmembership.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ArtistMembershipModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtArtistMembersh: String? =
      MyApp.getInstance().resources.getString(R.string.msg_artist_membersh)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup160: String? = MyApp.getInstance().resources.getString(R.string.msg_artist_membersh2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUploadPics: String? = MyApp.getInstance().resources.getString(R.string.lbl_upload_pics)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPicCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_pic_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPicCounterOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_pic_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPicCounterTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_pic_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPicCounterThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_pic_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPicCounterFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_pic_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUploadVideo: String? = MyApp.getInstance().resources.getString(R.string.lbl_upload_video)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVideo: String? = MyApp.getInstance().resources.getString(R.string.lbl_video)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRead: String? = MyApp.getInstance().resources.getString(R.string.lbl_read)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTermAndCondition: String? =
      MyApp.getInstance().resources.getString(R.string.msg_terms_condit)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_membership_arti)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupNine: String? = MyApp.getInstance().resources.getString(R.string.lbl_chikkanna)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTen: String? = MyApp.getInstance().resources.getString(R.string.lbl_chikkanna)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupEleven: String? = MyApp.getInstance().resources.getString(R.string.lbl_chikkanna)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTwelve: String? = MyApp.getInstance().resources.getString(R.string.lbl_chikkanna)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupThirteen: String? = MyApp.getInstance().resources.getString(R.string.lbl_chikkanna)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupFourteen: String? = MyApp.getInstance().resources.getString(R.string.lbl_chikkanna)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup149Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup150Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup151Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup152Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup153Value: String? = null
)
