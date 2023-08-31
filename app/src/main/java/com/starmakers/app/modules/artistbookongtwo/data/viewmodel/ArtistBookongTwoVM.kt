package com.starmakers.app.modules.artistbookongtwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.artistbookongtwo.`data`.model.ArtistBookongTwoModel
import com.starmakers.app.modules.artistbookongtwo.`data`.model.Gridrectangle110RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ArtistBookongTwoVM : ViewModel(), KoinComponent {
  val artistBookongTwoModel: MutableLiveData<ArtistBookongTwoModel> =
      MutableLiveData(ArtistBookongTwoModel())

  var navArguments: Bundle? = null

  val gridrectangle110List: MutableLiveData<MutableList<Gridrectangle110RowModel>> =
      MutableLiveData(mutableListOf())
}
