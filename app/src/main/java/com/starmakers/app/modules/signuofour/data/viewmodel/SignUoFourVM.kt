package com.starmakers.app.modules.signuofour.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.signuofour.`data`.model.SignUoFourModel
import org.koin.core.KoinComponent

class SignUoFourVM : ViewModel(), KoinComponent {
  val signUoFourModel: MutableLiveData<SignUoFourModel> = MutableLiveData(SignUoFourModel())

  var navArguments: Bundle? = null
}
