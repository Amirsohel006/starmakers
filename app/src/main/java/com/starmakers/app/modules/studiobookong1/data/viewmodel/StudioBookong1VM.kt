package com.starmakers.app.modules.studiobookong1.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.studiobookong1.`data`.model.StudioBookong1Model
import org.koin.core.KoinComponent

class StudioBookong1VM : ViewModel(), KoinComponent {
  val studioBookong1Model: MutableLiveData<StudioBookong1Model> =
      MutableLiveData(StudioBookong1Model())

  var navArguments: Bundle? = null
}
