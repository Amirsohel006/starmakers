package com.starmakers.app.modules.selectionlistthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.selectionlistthree.`data`.model.Listrectangle106RowModel
import com.starmakers.app.modules.selectionlistthree.`data`.model.SelectionListThreeModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SelectionListThreeVM : ViewModel(), KoinComponent {
  val selectionListThreeModel: MutableLiveData<SelectionListThreeModel> =
      MutableLiveData(SelectionListThreeModel())

  var navArguments: Bundle? = null

  val listrectangle106List: MutableLiveData<MutableList<Listrectangle106RowModel>> =
      MutableLiveData(mutableListOf())
}
