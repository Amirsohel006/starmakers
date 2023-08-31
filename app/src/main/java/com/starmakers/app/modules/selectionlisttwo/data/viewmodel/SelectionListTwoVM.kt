package com.starmakers.app.modules.selectionlisttwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.selectionlisttwo.`data`.model.Listrectangle141RowModel
import com.starmakers.app.modules.selectionlisttwo.`data`.model.SelectionListTwoModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SelectionListTwoVM : ViewModel(), KoinComponent {
  val selectionListTwoModel: MutableLiveData<SelectionListTwoModel> =
      MutableLiveData(SelectionListTwoModel())

  var navArguments: Bundle? = null

  val listrectangle140List: MutableLiveData<MutableList<Listrectangle141RowModel>> =
      MutableLiveData(mutableListOf())
}
