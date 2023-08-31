package com.starmakers.app.modules.help.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.help.`data`.model.HelpModel
import org.koin.core.KoinComponent

class HelpVM : ViewModel(), KoinComponent {
  val helpModel: MutableLiveData<HelpModel> = MutableLiveData(HelpModel())

  var navArguments: Bundle? = null
}
