package com.starmakers.app.modules.home.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.home.`data`.model.HomeModel
import com.starmakers.app.modules.home.`data`.model.SpinnerGroup122Model
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class HomeVM : ViewModel(), KoinComponent {
  val homeModel: MutableLiveData<HomeModel> = MutableLiveData(HomeModel())

  var navArguments: Bundle? = null

  val spinnerGroup122List: MutableLiveData<MutableList<SpinnerGroup122Model>> = MutableLiveData()
}
