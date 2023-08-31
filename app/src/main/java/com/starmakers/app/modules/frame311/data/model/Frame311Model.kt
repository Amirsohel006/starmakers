package com.starmakers.app.modules.frame311.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class Frame311Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtRahul: String? = MyApp.getInstance().resources.getString(R.string.lbl_rahul)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMobileNo: String? = MyApp.getInstance().resources.getString(R.string.lbl_9373636366)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmail: String? = MyApp.getInstance().resources.getString(R.string.lbl_rahul_gmail_com)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyAuditions: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_auditions)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNotifications: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_notifications)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMembership: String? = MyApp.getInstance().resources.getString(R.string.lbl_membership)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRequests: String? = MyApp.getInstance().resources.getString(R.string.lbl_requests)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDonationHistor: String? =
      MyApp.getInstance().resources.getString(R.string.msg_donation_histor)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtShareapp: String? = MyApp.getInstance().resources.getString(R.string.lbl_share_app)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHelpFAQs: String? = MyApp.getInstance().resources.getString(R.string.lbl_help_faqs)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrivacypolicy: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_privacy_policy)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAboutUs: String? = MyApp.getInstance().resources.getString(R.string.lbl_about_us)

)
