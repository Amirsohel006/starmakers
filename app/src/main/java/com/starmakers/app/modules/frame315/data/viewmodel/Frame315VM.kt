package com.starmakers.app.modules.frame315.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.frame315.`data`.model.Frame315Model
import org.koin.core.KoinComponent

class Frame315VM : ViewModel(), KoinComponent {
  val frame315Model: MutableLiveData<Frame315Model> = MutableLiveData(Frame315Model())

  var navArguments: Bundle? = null
}
