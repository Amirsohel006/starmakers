package com.starmakers.app.modules.auditionsthree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityAuditionsThreeBinding
import com.starmakers.app.modules.auditionsthree.`data`.model.Listrectangle146RowModel
import com.starmakers.app.modules.auditionsthree.`data`.viewmodel.AuditionsThreeVM
import com.starmakers.app.responses.BudgetResponse
import com.starmakers.app.responses.CampaignResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AuditionsThreeActivity :
    BaseActivity<ActivityAuditionsThreeBinding>(R.layout.activity_auditions_three) {
  private val viewModel: AuditionsThreeVM by viewModels<AuditionsThreeVM>()


  private lateinit var sessionManager:SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    sessionManager=SessionManager(this)


    getSearchDetails()

    binding.auditionsThreeVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }


  fun getSearchDetails(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getSearchDetails(authorization)

    call.enqueue(object : retrofit2.Callback<List<BudgetResponse>>{
      override fun onResponse(
        call: Call<List<BudgetResponse>>,
        response: Response<List<BudgetResponse>>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){
          binding.recyclerListrectangle146.apply {
            layoutManager = LinearLayoutManager(this@AuditionsThreeActivity, LinearLayoutManager.VERTICAL, false)
            val audtioAdapter = Listrectangle146Adapter(customerResponse)
            adapter = audtioAdapter
          }

        }
      }

      override fun onFailure(call: Call<List<BudgetResponse>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }
  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }



  companion object {
    const val TAG: String = "AUDITIONS_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AuditionsThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
