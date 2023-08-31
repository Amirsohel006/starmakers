package com.starmakers.app.modules.frame311.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.frame311.`data`.model.Frame311Model
import org.koin.core.KoinComponent

class Frame311VM : ViewModel(), KoinComponent {
  val frame311Model: MutableLiveData<Frame311Model> = MutableLiveData(Frame311Model())

  var navArguments: Bundle? = null
}
