package com.starmakers.app.modules.artistbookongtwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongTwoBinding
import com.starmakers.app.modules.artistbookongfour.ui.ArtistBookongFourActivity
import com.starmakers.app.modules.artistbookongthree.ui.ArtistBookongThreeActivity
import com.starmakers.app.modules.artistbookongtwo.`data`.model.Gridrectangle110RowModel
import com.starmakers.app.modules.artistbookongtwo.`data`.viewmodel.ArtistBookongTwoVM
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ArtistBookongTwoActivity :
    BaseActivity<ActivityArtistBookongTwoBinding>(R.layout.activity_artist_bookong_two) {
  private val viewModel: ArtistBookongTwoVM by viewModels<ArtistBookongTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val gridrectangle110Adapter =
    Gridrectangle110Adapter(viewModel.gridrectangle110List.value?:mutableListOf())
    binding.recyclerGridrectangle110.adapter = gridrectangle110Adapter
    gridrectangle110Adapter.setOnItemClickListener(
    object : Gridrectangle110Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Gridrectangle110RowModel) {
        onClickRecyclerGridrectangle110(view, position, item)
      }
    }
    )
    viewModel.gridrectangle110List.observe(this) {
      gridrectangle110Adapter.updateData(it)
    }
    binding.artistBookongTwoVM = viewModel
    setUpSearchViewGroupThirtyEightListener()
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerGridrectangle110(
    view: View,
    position: Int,
    item: Gridrectangle110RowModel
  ): Unit {
    when(view.id) {
      R.id.imageRectangle110 -> {
        onClickRecyclerGridrectangle110ImageRectangle110(view, position, item)
      }
    }
  }

  private fun setUpSearchViewGroupThirtyEightListener(): Unit {
    binding.searchViewGroupThirtyEight.setOnQueryTextListener(object :
    SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0 : String) : Boolean {
        // Performs search when user hit
        // the search button on the keyboard
        return false
      }
      override fun onQueryTextChange(p0 : String) : Boolean {
        // Start filtering the list as user
        // start entering the characters
        return false
      }
      })
    }

    fun onClickRecyclerGridrectangle110ImageRectangle110(
      view: View,
      position: Int,
      item: Gridrectangle110RowModel
    ): Unit {
      /** TODO As per your logic, Add constant type for item click.*/
      when(0) {
        0 -> {
          val destIntent = ArtistBookongFourActivity.getIntent(this, null)
          startActivity(destIntent)
        }
        1 -> {
          val destIntent = ArtistBookongThreeActivity.getIntent(this, null)
          startActivity(destIntent)
        }
      }
    }

    companion object {
      const val TAG: String = "ARTIST_BOOKONG_TWO_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, ArtistBookongTwoActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
