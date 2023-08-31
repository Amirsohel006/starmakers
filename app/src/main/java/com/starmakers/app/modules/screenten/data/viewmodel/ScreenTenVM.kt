package com.starmakers.app.modules.screenten.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.screenten.`data`.model.ScreenTenModel
import org.koin.core.KoinComponent

class ScreenTenVM : ViewModel(), KoinComponent {
  val screenTenModel: MutableLiveData<ScreenTenModel> = MutableLiveData(ScreenTenModel())

  var navArguments: Bundle? = null
}
