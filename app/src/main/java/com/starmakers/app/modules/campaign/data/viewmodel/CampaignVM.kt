package com.starmakers.app.modules.campaign.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.campaign.`data`.model.CampaignModel
import org.koin.core.KoinComponent

class CampaignVM : ViewModel(), KoinComponent {
  val campaignModel: MutableLiveData<CampaignModel> = MutableLiveData(CampaignModel())

  var navArguments: Bundle? = null
}
