package com.starmakers.app.modules.helptwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityHelpTwoBinding
import com.starmakers.app.modules.helptwo.`data`.viewmodel.HelpTwoVM
import com.starmakers.app.responses.AboutUsModel
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class HelpTwoActivity : BaseActivity<ActivityHelpTwoBinding>(R.layout.activity_help_two) {
  private val viewModel: HelpTwoVM by viewModels<HelpTwoVM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.helpTwoVM = viewModel

    sessionManager=SessionManager(this)
    val recyclerView=binding.myRecyclerView
    val serviceGenerator = ApiManager.apiInterface
    val authorization=sessionManager.fetchAuthToken()
    val call = serviceGenerator.getAbout(authorization)

    call.enqueue(object : retrofit2.Callback<MutableList<AboutUsModel>> {
      override fun onResponse(
        call: Call<MutableList<AboutUsModel>>,
        response: Response<MutableList<AboutUsModel>>
      ) {
        if (response.isSuccessful) {
          recyclerView.apply {
            layoutManager= LinearLayoutManager(this@HelpTwoActivity)
            adapter=AboutUsAdapter(response.body()!!)
          }
        }
      }

      override fun onFailure(call: Call<MutableList<AboutUsModel>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })




    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "HELP_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HelpTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
