package com.starmakers.app.modules.artistmembershiptwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistMembershipTwoBinding
import com.starmakers.app.modules.artistmembershiptwo.`data`.model.Listellipsetwentysix1RowModel
import com.starmakers.app.modules.artistmembershiptwo.`data`.model.Listpaypalone1RowModel
import com.starmakers.app.modules.artistmembershiptwo.`data`.viewmodel.ArtistMembershipTwoVM
import com.starmakers.app.modules.frame313.ui.Frame313Activity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ArtistMembershipTwoActivity :
    BaseActivity<ActivityArtistMembershipTwoBinding>(R.layout.activity_artist_membership_two) {
  private val viewModel: ArtistMembershipTwoVM by viewModels<ArtistMembershipTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listpaypaloneAdapter =
    ListpaypaloneAdapter(viewModel.listpaypaloneList.value?:mutableListOf())
    binding.recyclerListpaypalone.adapter = listpaypaloneAdapter
    listpaypaloneAdapter.setOnItemClickListener(
    object : ListpaypaloneAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listpaypalone1RowModel) {
        onClickRecyclerListpaypalone(view, position, item)
      }
    }
    )
    viewModel.listpaypaloneList.observe(this) {
      listpaypaloneAdapter.updateData(it)
    }
    val listellipsetwentysixAdapter =
    ListellipsetwentysixAdapter(viewModel.listellipsetwentysixList.value?:mutableListOf())
    binding.recyclerListellipsetwentysix.adapter = listellipsetwentysixAdapter
    listellipsetwentysixAdapter.setOnItemClickListener(
    object : ListellipsetwentysixAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item :
      Listellipsetwentysix1RowModel) {
        onClickRecyclerListellipsetwentysix(view, position, item)
      }
    }
    )
    viewModel.listellipsetwentysixList.observe(this) {
      listellipsetwentysixAdapter.updateData(it)
    }
    binding.artistMembershipTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnPayAndRegisterOne.setOnClickListener {
      val destIntent = Frame313Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListpaypalone(
    view: View,
    position: Int,
    item: Listpaypalone1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListellipsetwentysix(
    view: View,
    position: Int,
    item: Listellipsetwentysix1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ARTIST_MEMBERSHIP_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistMembershipTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
