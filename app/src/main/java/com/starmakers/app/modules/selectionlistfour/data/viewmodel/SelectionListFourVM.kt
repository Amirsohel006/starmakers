package com.starmakers.app.modules.selectionlistfour.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.selectionlistfour.`data`.model.Listrectangle140RowModel
import com.starmakers.app.modules.selectionlistfour.`data`.model.SelectionListFourModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SelectionListFourVM : ViewModel(), KoinComponent {
  val selectionListFourModel: MutableLiveData<SelectionListFourModel> =
      MutableLiveData(SelectionListFourModel())

  var navArguments: Bundle? = null

  val listrectangle140List: MutableLiveData<MutableList<Listrectangle140RowModel>> =
      MutableLiveData(mutableListOf())
}
