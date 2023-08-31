package com.starmakers.app.modules.signuotwo.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoTwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterMobilenu: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_mobile_nu)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOR: String? = MyApp.getInstance().resources.getString(R.string.lbl_or)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_already_have_an)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSignup: String? = MyApp.getInstance().resources.getString(R.string.lbl_signup)

)
