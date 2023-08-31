package com.starmakers.app.modules.studiobookongtwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.studiobookongtwo.`data`.model.Listrectanglenineteen1RowModel
import com.starmakers.app.modules.studiobookongtwo.`data`.model.StudioBookongTwoModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class StudioBookongTwoVM : ViewModel(), KoinComponent {
  val studioBookongTwoModel: MutableLiveData<StudioBookongTwoModel> =
      MutableLiveData(StudioBookongTwoModel())

  var navArguments: Bundle? = null

  val listrectanglenineteenList: MutableLiveData<MutableList<Listrectanglenineteen1RowModel>> =
      MutableLiveData(mutableListOf())
}
