package com.starmakers.app.modules.screennine.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.screennine.`data`.model.ScreenNineModel
import org.koin.core.KoinComponent

class ScreenNineVM : ViewModel(), KoinComponent {
  val screenNineModel: MutableLiveData<ScreenNineModel> = MutableLiveData(ScreenNineModel())

  var navArguments: Bundle? = null
}
