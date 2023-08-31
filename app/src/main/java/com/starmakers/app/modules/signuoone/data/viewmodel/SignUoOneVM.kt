package com.starmakers.app.modules.signuoone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.signuoone.`data`.model.SignUoOneModel
import org.koin.core.KoinComponent

class SignUoOneVM : ViewModel(), KoinComponent {
  val signUoOneModel: MutableLiveData<SignUoOneModel> = MutableLiveData(SignUoOneModel())

  var navArguments: Bundle? = null
}
