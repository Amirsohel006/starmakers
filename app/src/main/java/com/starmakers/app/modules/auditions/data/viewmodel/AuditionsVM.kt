package com.starmakers.app.modules.auditions.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.auditions.`data`.model.AuditionsModel
import com.starmakers.app.modules.auditions.`data`.model.AuditionsRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AuditionsVM : ViewModel(), KoinComponent {
  val auditionsModel: MutableLiveData<AuditionsModel> = MutableLiveData(AuditionsModel())

  var navArguments: Bundle? = null

  val auditionsList: MutableLiveData<MutableList<AuditionsRowModel>> =
      MutableLiveData(mutableListOf())
}
