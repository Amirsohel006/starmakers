package com.starmakers.app.modules.frame313.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.frame313.`data`.model.Frame313Model
import org.koin.core.KoinComponent

class Frame313VM : ViewModel(), KoinComponent {
  val frame313Model: MutableLiveData<Frame313Model> = MutableLiveData(Frame313Model())

  var navArguments: Bundle? = null
}
