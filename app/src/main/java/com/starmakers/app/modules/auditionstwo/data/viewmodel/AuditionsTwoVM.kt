package com.starmakers.app.modules.auditionstwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.auditionstwo.`data`.model.AuditionsTwoModel
import com.starmakers.app.modules.auditionstwo.`data`.model.AuditionsTwoRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AuditionsTwoVM : ViewModel(), KoinComponent {
  val auditionsTwoModel: MutableLiveData<AuditionsTwoModel> = MutableLiveData(AuditionsTwoModel())

  var navArguments: Bundle? = null

  val auditionsTwoList: MutableLiveData<MutableList<AuditionsTwoRowModel>> =
      MutableLiveData(mutableListOf())
}
