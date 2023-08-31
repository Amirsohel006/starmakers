package com.starmakers.app.modules.helptwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.helptwo.`data`.model.HelpTwoModel
import org.koin.core.KoinComponent

class HelpTwoVM : ViewModel(), KoinComponent {
  val helpTwoModel: MutableLiveData<HelpTwoModel> = MutableLiveData(HelpTwoModel())

  var navArguments: Bundle? = null
}
