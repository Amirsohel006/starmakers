package com.starmakers.app.modules.auditionsone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.auditionsone.`data`.model.AuditionsOneModel
import org.koin.core.KoinComponent

class AuditionsOneVM : ViewModel(), KoinComponent {
  val auditionsOneModel: MutableLiveData<AuditionsOneModel> = MutableLiveData(AuditionsOneModel())

  var navArguments: Bundle? = null
}
