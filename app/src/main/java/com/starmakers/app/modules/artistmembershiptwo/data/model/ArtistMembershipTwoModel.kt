package com.starmakers.app.modules.artistmembershiptwo.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ArtistMembershipTwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRegistrationDe: String? =
      MyApp.getInstance().resources.getString(R.string.msg_registration_de)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPaymentDetails: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_payment_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRegistrationFe: String? =
      MyApp.getInstance().resources.getString(R.string.msg_registration_fe)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRsCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_rs_500)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtChoosePayment: String? =
      MyApp.getInstance().resources.getString(R.string.msg_choose_payment)

)
