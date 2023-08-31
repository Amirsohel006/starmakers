package com.starmakers.app.modules.auditionsone.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class AuditionsOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFinanceOvervie: String? =
      MyApp.getInstance().resources.getString(R.string.msg_finance_overvie)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSpentAmount: String? = MyApp.getInstance().resources.getString(R.string.lbl_spent_amount)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.msg_collected_budge)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceOne: String? = MyApp.getInstance().resources.getString(R.string.msg_spent_amount)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceTwo: String? = MyApp.getInstance().resources.getString(R.string.msg_required_addnl)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceThree: String? = MyApp.getInstance().resources.getString(R.string.msg_total_spent_amo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSpentAmountOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_spent_amount)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceFour: String? = MyApp.getInstance().resources.getString(R.string.msg_above_the_budge)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceFive: String? = MyApp.getInstance().resources.getString(R.string.msg_below_the_budge)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtShareAmount: String? = MyApp.getInstance().resources.getString(R.string.lbl_share_amount)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtShareamountif: String? =
      MyApp.getInstance().resources.getString(R.string.msg_share_amount_if)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceSix: String? = MyApp.getInstance().resources.getString(R.string.msg_share_amount_if3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAvailableAmoun: String? =
      MyApp.getInstance().resources.getString(R.string.msg_available_amoun)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceSeven: String? =
      MyApp.getInstance().resources.getString(R.string.msg_available_amoun2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMovieKantara: String? = MyApp.getInstance().resources.getString(R.string.lbl_movie_kantara)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGenreMystery: String? = MyApp.getInstance().resources.getString(R.string.lbl_genre_mystery)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStoryline: String? = MyApp.getInstance().resources.getString(R.string.lbl_storyline)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAppxBudget: String? = MyApp.getInstance().resources.getString(R.string.lbl_appx_budget)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtReleasingDate: String? =
      MyApp.getInstance().resources.getString(R.string.msg_releasing_date)

)
