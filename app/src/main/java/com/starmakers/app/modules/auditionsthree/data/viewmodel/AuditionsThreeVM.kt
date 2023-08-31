package com.starmakers.app.modules.auditionsthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.auditionsthree.`data`.model.AuditionsThreeModel
import com.starmakers.app.modules.auditionsthree.`data`.model.Listrectangle146RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AuditionsThreeVM : ViewModel(), KoinComponent {
  val auditionsThreeModel: MutableLiveData<AuditionsThreeModel> =
      MutableLiveData(AuditionsThreeModel())

  var navArguments: Bundle? = null

  val listrectangle146List: MutableLiveData<MutableList<Listrectangle146RowModel>> =
      MutableLiveData(mutableListOf())
}
