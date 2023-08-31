package com.starmakers.app.modules.activities.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ActivitiesRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtArtistMembersh: String? =
      MyApp.getInstance().resources.getString(R.string.msg_artist_members)

)
