package com.starmakers.app.modules.requestone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.requestone.`data`.model.RequestOneModel
import org.koin.core.KoinComponent

class RequestOneVM : ViewModel(), KoinComponent {
  val requestOneModel: MutableLiveData<RequestOneModel> = MutableLiveData(RequestOneModel())

  var navArguments: Bundle? = null
}
