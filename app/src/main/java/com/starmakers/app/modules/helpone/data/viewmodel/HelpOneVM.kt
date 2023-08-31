package com.starmakers.app.modules.helpone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.helpone.`data`.model.HelpOneModel
import org.koin.core.KoinComponent

class HelpOneVM : ViewModel(), KoinComponent {
  val helpOneModel: MutableLiveData<HelpOneModel> = MutableLiveData(HelpOneModel())

  var navArguments: Bundle? = null
}
