package com.starmakers.app.modules.paymentpage.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class PaymentPageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPaymentPage: String? = MyApp.getInstance().resources.getString(R.string.lbl_payment_page)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterDonation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_donation)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_500)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_1000)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_2000)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtChoosePayment: String? =
      MyApp.getInstance().resources.getString(R.string.msg_choose_payment)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etPriceValue: String? = null
)
