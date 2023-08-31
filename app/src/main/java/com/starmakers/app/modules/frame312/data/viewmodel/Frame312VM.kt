package com.starmakers.app.modules.frame312.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.frame312.`data`.model.Frame312Model
import org.koin.core.KoinComponent

class Frame312VM : ViewModel(), KoinComponent {
  val frame312Model: MutableLiveData<Frame312Model> = MutableLiveData(Frame312Model())

  var navArguments: Bundle? = null
}
