package com.starmakers.app.modules.artistmembershiptwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.artistmembershiptwo.`data`.model.ArtistMembershipTwoModel
import com.starmakers.app.modules.artistmembershiptwo.`data`.model.Listellipsetwentysix1RowModel
import com.starmakers.app.modules.artistmembershiptwo.`data`.model.Listpaypalone1RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ArtistMembershipTwoVM : ViewModel(), KoinComponent {
  val artistMembershipTwoModel: MutableLiveData<ArtistMembershipTwoModel> =
      MutableLiveData(ArtistMembershipTwoModel())

  var navArguments: Bundle? = null

  val listpaypaloneList: MutableLiveData<MutableList<Listpaypalone1RowModel>> =
      MutableLiveData(mutableListOf())

  val listellipsetwentysixList: MutableLiveData<MutableList<Listellipsetwentysix1RowModel>> =
      MutableLiveData(mutableListOf())
}
