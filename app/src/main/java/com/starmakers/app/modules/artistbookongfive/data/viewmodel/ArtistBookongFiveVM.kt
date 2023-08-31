package com.starmakers.app.modules.artistbookongfive.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.artistbookongfive.`data`.model.ArtistBookongFiveModel
import com.starmakers.app.modules.artistbookongfive.`data`.model.SpinnerComponentEightModel
import com.starmakers.app.modules.artistbookongfive.`data`.model.SpinnerComponentOneModel
import com.starmakers.app.modules.artistbookongfive.`data`.model.SpinnerGroup122Model
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ArtistBookongFiveVM : ViewModel(), KoinComponent {
  val artistBookongFiveModel: MutableLiveData<ArtistBookongFiveModel> =
      MutableLiveData(ArtistBookongFiveModel())

  var navArguments: Bundle? = null

  val spinnerGroup122List: MutableLiveData<MutableList<SpinnerGroup122Model>> = MutableLiveData()

  val spinnerComponentEightList: MutableLiveData<MutableList<SpinnerComponentEightModel>> =
      MutableLiveData()

  val spinnerComponentOneList: MutableLiveData<MutableList<SpinnerComponentOneModel>> =
      MutableLiveData()
}
