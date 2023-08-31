package com.starmakers.app.modules.frametwentythree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.frametwentythree.`data`.model.FrameTwentythreeModel
import org.koin.core.KoinComponent

class FrameTwentythreeVM : ViewModel(), KoinComponent {
  val frameTwentythreeModel: MutableLiveData<FrameTwentythreeModel> =
      MutableLiveData(FrameTwentythreeModel())

  var navArguments: Bundle? = null
}
