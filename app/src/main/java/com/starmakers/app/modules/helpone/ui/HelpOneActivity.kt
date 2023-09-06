package com.starmakers.app.modules.helpone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityHelpOneBinding
import com.starmakers.app.modules.helpone.`data`.viewmodel.HelpOneVM
import com.starmakers.app.responses.PrivacyPolicyModel
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class HelpOneActivity : BaseActivity<ActivityHelpOneBinding>(R.layout.activity_help_one) {
  private val viewModel: HelpOneVM by viewModels<HelpOneVM>()


  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.helpOneVM = viewModel

    sessionManager=SessionManager(this)

    val recyclerView=binding.recyclerViewPrivacy
    val serviceGenerator = ApiManager.apiInterface
    val authorization=sessionManager.fetchAuthToken()
    val call = serviceGenerator.getPrivacyPolicy(authorization)

    call.enqueue(object : retrofit2.Callback<ArrayList<PrivacyPolicyModel>> {
      override fun onResponse(
        call: Call<ArrayList<PrivacyPolicyModel>>,
        response: Response<ArrayList<PrivacyPolicyModel>>
      ) {
        if (response.isSuccessful) {
          recyclerView.apply {
            layoutManager= LinearLayoutManager(this@HelpOneActivity)
            adapter= PrivacyPolicyAdapter(response.body()!!)
          }
        }
      }

      override fun onFailure(call: Call<ArrayList<PrivacyPolicyModel>>, t: Throwable) {
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
    const val TAG: String = "HELP_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HelpOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
