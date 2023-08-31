package com.starmakers.app.modules.frame317.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.frame317.`data`.model.Frame317Model
import org.koin.core.KoinComponent

class Frame317VM : ViewModel(), KoinComponent {
  val frame317Model: MutableLiveData<Frame317Model> = MutableLiveData(Frame317Model())

  var navArguments: Bundle? = null
}
