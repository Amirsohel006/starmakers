package com.starmakers.app.modules.screenseven.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.screenseven.`data`.model.ScreenSevenModel
import org.koin.core.KoinComponent

class ScreenSevenVM : ViewModel(), KoinComponent {
  val screenSevenModel: MutableLiveData<ScreenSevenModel> = MutableLiveData(ScreenSevenModel())

  var navArguments: Bundle? = null
}
