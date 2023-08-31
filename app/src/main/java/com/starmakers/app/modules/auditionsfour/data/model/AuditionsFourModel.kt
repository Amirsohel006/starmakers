package com.starmakers.app.modules.auditionsfour.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class AuditionsFourModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_kgf_auditions)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_enter_details)
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
  var txtActingVideos: String? = MyApp.getInstance().resources.getString(R.string.lbl_acting_videos)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVideoCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_video_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVideoCounterOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_video_2)
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
