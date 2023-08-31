package com.starmakers.app.modules.artistbookongone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.artistbookongone.`data`.model.ArtistBookongOneModel
import org.koin.core.KoinComponent

class ArtistBookongOneVM : ViewModel(), KoinComponent {
  val artistBookongOneModel: MutableLiveData<ArtistBookongOneModel> =
      MutableLiveData(ArtistBookongOneModel())

  var navArguments: Bundle? = null
}
