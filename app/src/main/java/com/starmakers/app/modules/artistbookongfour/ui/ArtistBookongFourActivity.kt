package com.starmakers.app.modules.artistbookongfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongFourBinding
import com.starmakers.app.modules.artistbookongfour.`data`.model.Listrectangle114RowModel
import com.starmakers.app.modules.artistbookongfour.`data`.viewmodel.ArtistBookongFourVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ArtistBookongFourActivity :
    BaseActivity<ActivityArtistBookongFourBinding>(R.layout.activity_artist_bookong_four) {
  private val viewModel: ArtistBookongFourVM by viewModels<ArtistBookongFourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectangle113Adapter =
    Listrectangle113Adapter(viewModel.listrectangle113List.value?:mutableListOf())
    binding.recyclerListrectangle113.adapter = listrectangle113Adapter
    listrectangle113Adapter.setOnItemClickListener(
    object : Listrectangle113Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listrectangle114RowModel) {
        onClickRecyclerListrectangle113(view, position, item)
      }
    }
    )
    viewModel.listrectangle113List.observe(this) {
      listrectangle113Adapter.updateData(it)
    }
    binding.artistBookongFourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListrectangle113(
    view: View,
    position: Int,
    item: Listrectangle114RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ARTIST_BOOKONG_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistBookongFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
