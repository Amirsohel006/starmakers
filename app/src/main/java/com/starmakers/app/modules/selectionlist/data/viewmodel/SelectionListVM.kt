package com.starmakers.app.modules.selectionlist.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.selectionlist.`data`.model.SelectionListModel
import com.starmakers.app.modules.selectionlist.`data`.model.SelectionListRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SelectionListVM : ViewModel(), KoinComponent {
  val selectionListModel: MutableLiveData<SelectionListModel> =
      MutableLiveData(SelectionListModel())

  var navArguments: Bundle? = null

  val selectionListList: MutableLiveData<MutableList<SelectionListRowModel>> =
      MutableLiveData(mutableListOf())
}
