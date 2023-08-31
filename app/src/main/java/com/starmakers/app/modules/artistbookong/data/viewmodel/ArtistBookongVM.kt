package com.starmakers.app.modules.artistbookong.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.artistbookong.`data`.model.ArtistBookongModel
import org.koin.core.KoinComponent

class ArtistBookongVM : ViewModel(), KoinComponent {
  val artistBookongModel: MutableLiveData<ArtistBookongModel> =
      MutableLiveData(ArtistBookongModel())

  var navArguments: Bundle? = null
}
