package com.starmakers.app.modules.regstrationdetails.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.regstrationdetails.`data`.model.Listellipsetwentysix2RowModel
import com.starmakers.app.modules.regstrationdetails.`data`.model.Listpaypalone2RowModel
import com.starmakers.app.modules.regstrationdetails.`data`.model.RegstrationDetailsModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class RegstrationDetailsVM : ViewModel(), KoinComponent {
  val regstrationDetailsModel: MutableLiveData<RegstrationDetailsModel> =
      MutableLiveData(RegstrationDetailsModel())

  var navArguments: Bundle? = null

  val listpaypaloneList: MutableLiveData<MutableList<Listpaypalone2RowModel>> =
      MutableLiveData(mutableListOf())

  val listellipsetwentysixList: MutableLiveData<MutableList<Listellipsetwentysix2RowModel>> =
      MutableLiveData(mutableListOf())
}
