package com.starmakers.app.modules.signuotwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.signuotwo.`data`.model.SignUoTwoModel
import org.koin.core.KoinComponent

class SignUoTwoVM : ViewModel(), KoinComponent {
  val signUoTwoModel: MutableLiveData<SignUoTwoModel> = MutableLiveData(SignUoTwoModel())

  var navArguments: Bundle? = null
}
