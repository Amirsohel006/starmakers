package com.starmakers.app.modules.request.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.request.`data`.model.RequestModel
import org.koin.core.KoinComponent

class RequestVM : ViewModel(), KoinComponent {
  val requestModel: MutableLiveData<RequestModel> = MutableLiveData(RequestModel())

  var navArguments: Bundle? = null
}
