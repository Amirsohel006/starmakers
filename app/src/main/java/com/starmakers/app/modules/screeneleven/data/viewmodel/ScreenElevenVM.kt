package com.starmakers.app.modules.screeneleven.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.screeneleven.`data`.model.ScreenElevenModel
import org.koin.core.KoinComponent

class ScreenElevenVM : ViewModel(), KoinComponent {
  val screenElevenModel: MutableLiveData<ScreenElevenModel> = MutableLiveData(ScreenElevenModel())

  var navArguments: Bundle? = null
}
