package com.starmakers.app.modules.artistmembershipone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.artistmembershipone.`data`.model.ArtistMembershipOneModel
import com.starmakers.app.modules.artistmembershipone.`data`.model.SpinnerComponentOneModel
import com.starmakers.app.modules.artistmembershipone.`data`.model.SpinnerComponentSevenModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ArtistMembershipOneVM : ViewModel(), KoinComponent {
  val artistMembershipOneModel: MutableLiveData<ArtistMembershipOneModel> =
      MutableLiveData(ArtistMembershipOneModel())

  var navArguments: Bundle? = null

  val spinnerComponentSevenList: MutableLiveData<MutableList<SpinnerComponentSevenModel>> =
      MutableLiveData()

  val spinnerComponentOneList: MutableLiveData<MutableList<SpinnerComponentOneModel>> =
      MutableLiveData()
}
