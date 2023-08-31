package com.starmakers.app.modules.artistbookongthree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongThreeBinding
import com.starmakers.app.modules.artistbookongthree.`data`.model.Listrectangle113RowModel
import com.starmakers.app.modules.artistbookongthree.`data`.viewmodel.ArtistBookongThreeVM
import com.starmakers.app.modules.frame312.ui.Frame312Activity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ArtistBookongThreeActivity :
    BaseActivity<ActivityArtistBookongThreeBinding>(R.layout.activity_artist_bookong_three) {
  private val viewModel: ArtistBookongThreeVM by viewModels<ArtistBookongThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectangle113Adapter =
    Listrectangle113Adapter(viewModel.listrectangle113List.value?:mutableListOf())
    binding.recyclerListrectangle113.adapter = listrectangle113Adapter
    listrectangle113Adapter.setOnItemClickListener(
    object : Listrectangle113Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listrectangle113RowModel) {
        onClickRecyclerListrectangle113(view, position, item)
      }
    }
    )
    viewModel.listrectangle113List.observe(this) {
      listrectangle113Adapter.updateData(it)
    }
    binding.artistBookongThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnRequestBookingOne.setOnClickListener {
      val destIntent = Frame312Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListrectangle113(
    view: View,
    position: Int,
    item: Listrectangle113RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ARTIST_BOOKONG_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistBookongThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
