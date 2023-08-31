package com.starmakers.app.modules.screenfive.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.screenfive.`data`.model.ScreenFiveModel
import org.koin.core.KoinComponent

class ScreenFiveVM : ViewModel(), KoinComponent {
  val screenFiveModel: MutableLiveData<ScreenFiveModel> = MutableLiveData(ScreenFiveModel())

  var navArguments: Bundle? = null
}
