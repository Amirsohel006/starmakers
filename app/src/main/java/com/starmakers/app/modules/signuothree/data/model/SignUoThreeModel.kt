package com.starmakers.app.modules.signuothree.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoThreeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtVerifyMobileN: String? =
      MyApp.getInstance().resources.getString(R.string.msg_verify_mobile_n)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPleaseenterth: String? =
      MyApp.getInstance().resources.getString(R.string.msg_please_enter_th)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_91_71)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDidntreceive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_didn_t_receive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtResendOTP: String? = MyApp.getInstance().resources.getString(R.string.lbl_resend_otp)

)
