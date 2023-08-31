package com.starmakers.app.modules.artistmembership.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.artistmembership.`data`.model.ArtistMembershipModel
import com.starmakers.app.modules.artistmembership.`data`.model.SpinnerComponentOneModel
import com.starmakers.app.modules.artistmembership.`data`.model.SpinnerComponentSevenModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ArtistMembershipVM : ViewModel(), KoinComponent {
  val artistMembershipModel: MutableLiveData<ArtistMembershipModel> =
      MutableLiveData(ArtistMembershipModel())

  var navArguments: Bundle? = null

  val spinnerComponentSevenList: MutableLiveData<MutableList<SpinnerComponentSevenModel>> =
      MutableLiveData()

  val spinnerComponentOneList: MutableLiveData<MutableList<SpinnerComponentOneModel>> =
      MutableLiveData()
}
