package com.starmakers.app.modules.artistbookongfour.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.artistbookongfour.`data`.model.ArtistBookongFourModel
import com.starmakers.app.modules.artistbookongfour.`data`.model.Listrectangle114RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class   ArtistBookongFourVM : ViewModel(), KoinComponent {
  val artistBookongFourModel: MutableLiveData<ArtistBookongFourModel> =
      MutableLiveData(ArtistBookongFourModel())

  var navArguments: Bundle? = null

  val listrectangle113List: MutableLiveData<MutableList<Listrectangle114RowModel>> =
      MutableLiveData(mutableListOf())
}
