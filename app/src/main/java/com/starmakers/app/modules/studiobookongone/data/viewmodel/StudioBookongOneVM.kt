package com.starmakers.app.modules.studiobookongone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.studiobookongone.`data`.model.ListrectanglenineteenRowModel
import com.starmakers.app.modules.studiobookongone.`data`.model.StudioBookongOneModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class StudioBookongOneVM : ViewModel(), KoinComponent {
  val studioBookongOneModel: MutableLiveData<StudioBookongOneModel> =
      MutableLiveData(StudioBookongOneModel())

  var navArguments: Bundle? = null

  val listrectanglenineteenList: MutableLiveData<MutableList<ListrectanglenineteenRowModel>> =
      MutableLiveData(mutableListOf())
}
