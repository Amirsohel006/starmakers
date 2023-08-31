package com.starmakers.app.modules.artistbookongthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.artistbookongthree.`data`.model.ArtistBookongThreeModel
import com.starmakers.app.modules.artistbookongthree.`data`.model.Listrectangle113RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ArtistBookongThreeVM : ViewModel(), KoinComponent {
  val artistBookongThreeModel: MutableLiveData<ArtistBookongThreeModel> =
      MutableLiveData(ArtistBookongThreeModel())

  var navArguments: Bundle? = null

  val listrectangle113List: MutableLiveData<MutableList<Listrectangle113RowModel>> =
      MutableLiveData(mutableListOf())
}
