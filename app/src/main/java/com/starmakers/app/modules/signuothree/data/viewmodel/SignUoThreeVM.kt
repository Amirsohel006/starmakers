package com.starmakers.app.modules.signuothree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.signuothree.`data`.model.SignUoThreeModel
import org.koin.core.KoinComponent

class SignUoThreeVM : ViewModel(), KoinComponent {
  val signUoThreeModel: MutableLiveData<SignUoThreeModel> = MutableLiveData(SignUoThreeModel())

  var navArguments: Bundle? = null
}
