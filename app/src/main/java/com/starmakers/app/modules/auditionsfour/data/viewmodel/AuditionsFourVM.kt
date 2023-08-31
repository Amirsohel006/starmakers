package com.starmakers.app.modules.auditionsfour.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.auditionsfour.`data`.model.AuditionsFourModel
import com.starmakers.app.modules.auditionsfour.`data`.model.SpinnerComponentNineModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AuditionsFourVM : ViewModel(), KoinComponent {
  val auditionsFourModel: MutableLiveData<AuditionsFourModel> =
      MutableLiveData(AuditionsFourModel())

  var navArguments: Bundle? = null

  val spinnerComponentNineList: MutableLiveData<MutableList<SpinnerComponentNineModel>> =
      MutableLiveData()
}
