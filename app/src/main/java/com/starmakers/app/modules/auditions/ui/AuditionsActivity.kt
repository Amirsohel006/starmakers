package com.starmakers.app.modules.auditions.ui

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
import com.starmakers.app.databinding.ActivityAuditionsBinding
import com.starmakers.app.modules.auditions.`data`.model.AuditionsRowModel
import com.starmakers.app.modules.auditions.`data`.viewmodel.AuditionsVM
import com.starmakers.app.modules.auditionsfour.ui.AuditionsFourActivity
import com.starmakers.app.modules.campaignone.ui.CampaignOneActivity
import com.starmakers.app.modules.frame314.ui.Frame314Activity
import com.starmakers.app.modules.selectionlistone.ui.SelectionListOneActivity
import com.starmakers.app.responses.Audition
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AuditionsActivity : BaseActivity<ActivityAuditionsBinding>(R.layout.activity_auditions) {
  private val viewModel: AuditionsVM by viewModels<AuditionsVM>()


  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    sessionManager=SessionManager(this)



    fetchData()
//    val auditionsAdapter = AuditionsAdapter(viewModel.auditionsList.value?:mutableListOf())
//    binding.recyclerAuditions.adapter = auditionsAdapter
//    auditionsAdapter.setOnItemClickListener(
//    object : AuditionsAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : AuditionsRowModel) {
//        onClickRecyclerAuditions(view, position, item)
//      }
//    }
//    )
//    viewModel.auditionsList.observe(this) {
//      auditionsAdapter.updateData(it)
//    }
    binding.auditionsVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.txtSelectionList.setOnClickListener {
      val destIntent = SelectionListOneActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
    }
  }


  private fun fetchData(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getAudition(authorization)

    call.enqueue(object : retrofit2.Callback<Audition>{
      override fun onResponse(
        call: Call<Audition>,
        response: Response<Audition>
      ) {
        val customerResponse=response.body()

        if((customerResponse!=null)   && (customerResponse.status=="success")){

         val auditionData=response.body()

          binding.recyclerAuditions.apply {
            layoutManager=LinearLayoutManager(this@AuditionsActivity,LinearLayoutManager.VERTICAL,false)
            val audtioAdapter=AuditionsAdapter(auditionData!!.data)
            binding.recyclerAuditions.adapter=audtioAdapter
          }
        }
      }

      override fun onFailure(call: Call<Audition>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }
  fun onClickRecyclerAuditions(
    view: View,
    position: Int,
    item: AuditionsRowModel
  ): Unit {
    when(view.id) {
      R.id.imageRectangle106 -> {
        val destIntent = CampaignOneActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      R.id.btnParticipate -> {
        onClickRecyclerAuditionsBtnParticipate(view, position, item)
      }
    }
  }

  fun onClickRecyclerAuditionsBtnParticipate(
    view: View,
    position: Int,
    item: AuditionsRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/
    when(0) {
      0 -> {
        val destIntent = AuditionsFourActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      1 -> {
        val destIntent = Frame314Activity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "AUDITIONS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AuditionsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
