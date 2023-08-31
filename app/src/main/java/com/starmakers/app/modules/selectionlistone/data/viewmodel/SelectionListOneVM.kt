package com.starmakers.app.modules.selectionlistone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.selectionlistone.`data`.model.Listrectangle107RowModel
import com.starmakers.app.modules.selectionlistone.`data`.model.SelectionListOneModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SelectionListOneVM : ViewModel(), KoinComponent {
  val selectionListOneModel: MutableLiveData<SelectionListOneModel> =
      MutableLiveData(SelectionListOneModel())

  var navArguments: Bundle? = null

  val listrectangle106List: MutableLiveData<MutableList<Listrectangle107RowModel>> =
      MutableLiveData(mutableListOf())
}
