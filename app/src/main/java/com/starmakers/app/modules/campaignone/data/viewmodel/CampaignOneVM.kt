package com.starmakers.app.modules.campaignone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.campaignone.`data`.model.CampaignOneModel
import org.koin.core.KoinComponent

class CampaignOneVM : ViewModel(), KoinComponent {
  val campaignOneModel: MutableLiveData<CampaignOneModel> = MutableLiveData(CampaignOneModel())

  var navArguments: Bundle? = null
}
