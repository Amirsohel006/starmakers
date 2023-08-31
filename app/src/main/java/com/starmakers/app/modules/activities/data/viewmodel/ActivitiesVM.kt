package com.starmakers.app.modules.activities.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.activities.`data`.model.ActivitiesModel
import com.starmakers.app.modules.activities.`data`.model.ActivitiesRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ActivitiesVM : ViewModel(), KoinComponent {
  val activitiesModel: MutableLiveData<ActivitiesModel> = MutableLiveData(ActivitiesModel())

  var navArguments: Bundle? = null

  val activitiesList: MutableLiveData<MutableList<ActivitiesRowModel>> =
      MutableLiveData(mutableListOf())
}
