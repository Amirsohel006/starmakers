package com.starmakers.app.modules.selectionlistone.ui

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
import com.starmakers.app.databinding.ActivitySelectionListOneBinding
import com.starmakers.app.modules.auditions.ui.AuditionsActivity
import com.starmakers.app.modules.selectionlistone.`data`.model.Listrectangle107RowModel
import com.starmakers.app.modules.selectionlistone.`data`.viewmodel.SelectionListOneVM
import com.starmakers.app.modules.selectionlisttwo.ui.SelectionListTwoActivity
import com.starmakers.app.responses.SelectionDataResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SelectionListOneActivity :
    BaseActivity<ActivitySelectionListOneBinding>(R.layout.activity_selection_list_one) {
  private val viewModel: SelectionListOneVM by viewModels<SelectionListOneVM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    sessionManager=SessionManager(this)

    fetchData()


//    viewModel.navArguments = intent.extras?.getBundle("bundle")
//    val listrectangle106Adapter =
//    Listrectangle106Adapter(viewModel.listrectangle106List.value?:mutableListOf())
//    binding.recyclerListrectangle106.adapter = listrectangle106Adapter
//    listrectangle106Adapter.setOnItemClickListener(
//    object : Listrectangle106Adapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : Listrectangle107RowModel) {
//        onClickRecyclerListrectangle106(view, position, item)
//      }
//    }
//    )
//    viewModel.listrectangle106List.observe(this) {
//      listrectangle106Adapter.updateData(it)
//    }
    binding.selectionListOneVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)

  }


  private fun fetchData(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.get_selection_list(authorization)

    call.enqueue(object : retrofit2.Callback<SelectionDataResponse>{
      override fun onResponse(
        call: Call<SelectionDataResponse>,
        response: Response<SelectionDataResponse>
      ) {

        val selectionResponse=response.body()
        if((selectionResponse!=null)   && (selectionResponse.message=="Success")){
          val selectionData= response.body()

          binding.recyclerListrectangle106.apply {
            layoutManager=
              LinearLayoutManager(this@SelectionListOneActivity, LinearLayoutManager.VERTICAL,false)
            val selectionAdapter=Listrectangle106Adapter(selectionData!!.data)
            binding.recyclerListrectangle106.adapter =selectionAdapter
          }
        }
      }

      override fun onFailure(call: Call<SelectionDataResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.txtAuditionsOne.setOnClickListener {
      val destIntent = AuditionsActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
    }
  }

  fun onClickRecyclerListrectangle106(
    view: View,
    position: Int,
    item: Listrectangle107RowModel
  ): Unit {
    when(view.id) {
      R.id.btnSelectionListOne ->  {
        val destIntent = SelectionListTwoActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "SELECTION_LIST_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SelectionListOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
