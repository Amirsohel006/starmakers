package com.starmakers.app.modules.frametwentyfour.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.frametwentyfour.`data`.model.FrameTwentyfourModel
import org.koin.core.KoinComponent

class FrameTwentyfourVM : ViewModel(), KoinComponent {
  val frameTwentyfourModel: MutableLiveData<FrameTwentyfourModel> =
      MutableLiveData(FrameTwentyfourModel())

  var navArguments: Bundle? = null
}
