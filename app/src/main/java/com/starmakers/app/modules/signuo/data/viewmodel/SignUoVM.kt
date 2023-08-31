package com.starmakers.app.modules.signuo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.signuo.`data`.model.SignUoModel
import org.koin.core.KoinComponent

class SignUoVM : ViewModel(), KoinComponent {
  val signUoModel: MutableLiveData<SignUoModel> = MutableLiveData(SignUoModel())

  var navArguments: Bundle? = null
}
