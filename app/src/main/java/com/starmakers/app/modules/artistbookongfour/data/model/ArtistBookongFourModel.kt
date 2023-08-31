package com.starmakers.app.modules.artistbookongfour.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ArtistBookongFourModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtChikkanna: String? = MyApp.getInstance().resources.getString(R.string.lbl_chikkanna)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtName: String? = MyApp.getInstance().resources.getString(R.string.lbl_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAge: String? = MyApp.getInstance().resources.getString(R.string.lbl_age2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeight: String? = MyApp.getInstance().resources.getString(R.string.lbl_height2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeight: String? = MyApp.getInstance().resources.getString(R.string.lbl_weight2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNatureofArtis: String? =
      MyApp.getInstance().resources.getString(R.string.msg_nature_of_artis)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtExperience: String? = MyApp.getInstance().resources.getString(R.string.lbl_experience)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTotalnumberof: String? =
      MyApp.getInstance().resources.getString(R.string.msg_total_number_of)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtContactNumber: String? =
      MyApp.getInstance().resources.getString(R.string.msg_contact_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPics: String? = MyApp.getInstance().resources.getString(R.string.lbl_pics)
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
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_movies)

)
