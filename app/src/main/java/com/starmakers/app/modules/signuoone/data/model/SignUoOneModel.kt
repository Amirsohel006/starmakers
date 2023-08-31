package com.starmakers.app.modules.signuoone.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAddProfile: String? = MyApp.getInstance().resources.getString(R.string.lbl_add_profile)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTermAndCondition: String? =
      MyApp.getInstance().resources.getString(R.string.msg_accept_all_term)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup421Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup422Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup423Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup424Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup425Value: String? = null
)
