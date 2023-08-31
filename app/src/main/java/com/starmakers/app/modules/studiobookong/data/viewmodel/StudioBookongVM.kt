package com.starmakers.app.modules.studiobookong.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.studiobookong.`data`.model.StudioBookongModel
import com.starmakers.app.modules.studiobookong.`data`.model.StudioBookongRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class StudioBookongVM : ViewModel(), KoinComponent {
  val studioBookongModel: MutableLiveData<StudioBookongModel> =
      MutableLiveData(StudioBookongModel())

  var navArguments: Bundle? = null

  val studioBookongList: MutableLiveData<MutableList<StudioBookongRowModel>> =
      MutableLiveData(mutableListOf())
}
