package com.starmakers.app.modules.frame311.ui

import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrame311Binding
import com.starmakers.app.modules.artistbookong.ui.ArtistBookongActivity
import com.starmakers.app.modules.artistmembership.ui.ArtistMembershipActivity
import com.starmakers.app.modules.auditionsthree.ui.AuditionsThreeActivity
import com.starmakers.app.modules.frame311.`data`.viewmodel.Frame311VM
import com.starmakers.app.modules.help.ui.HelpActivity
import com.starmakers.app.modules.helpone.ui.HelpOneActivity
import com.starmakers.app.modules.helptwo.ui.HelpTwoActivity
import com.starmakers.app.modules.selectionlist.ui.SelectionListActivity
import com.starmakers.app.modules.selectionlistthree.ui.SelectionListThreeActivity
import kotlin.String
import kotlin.Unit

class Frame311Activity : BaseActivity<ActivityFrame311Binding>(R.layout.activity_frame_311) {
  private val viewModel: Frame311VM by viewModels<Frame311VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame311VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowgroup.setOnClickListener {
      val destIntent = SelectionListThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowreply.setOnClickListener {
      val destIntent = AuditionsThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRownotification.setOnClickListener {
      val destIntent = SelectionListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowinfo.setOnClickListener {
      val destIntent = HelpOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcomputer.setOnClickListener {
      val destIntent = ArtistMembershipActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowquestion.setOnClickListener {
      val destIntent = HelpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtRahul.setOnClickListener {
      val destIntent = ArtistBookongActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowinfoOne.setOnClickListener {
      val destIntent = HelpTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME311ACTIVITY"

  }
}
