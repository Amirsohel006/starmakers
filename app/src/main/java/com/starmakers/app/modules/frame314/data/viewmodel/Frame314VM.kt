package com.starmakers.app.modules.frame314.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.frame314.`data`.model.Frame314Model
import org.koin.core.KoinComponent

class Frame314VM : ViewModel(), KoinComponent {
  val frame314Model: MutableLiveData<Frame314Model> = MutableLiveData(Frame314Model())

  var navArguments: Bundle? = null
}
