package com.starmakers.app.modules.frame316.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.frame316.`data`.model.Frame316Model
import org.koin.core.KoinComponent

class Frame316VM : ViewModel(), KoinComponent {
  val frame316Model: MutableLiveData<Frame316Model> = MutableLiveData(Frame316Model())

  var navArguments: Bundle? = null
}
