package com.starmakers.app.modules.help.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityHelpBinding
import com.starmakers.app.modules.help.`data`.viewmodel.HelpVM
import com.starmakers.app.responses.ContactUs
import com.starmakers.app.responses.FAQItem
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class HelpActivity : BaseActivity<ActivityHelpBinding>(R.layout.activity_help) {
  private val viewModel: HelpVM by viewModels<HelpVM>()
  private lateinit var sessionManager: SessionManager
  private val faqList = mutableListOf<FAQItem>()
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.helpVM = viewModel

    sessionManager=SessionManager(this)

    val adapter = HelpFaqAdapter(faqList) { notification ->
      val intent = Intent(this, HelpDetailActivity::class.java)
      intent.putExtra("faqId", notification.id)
      startActivity(intent)
    }

    val recyclerView=binding.recyclerFAQs
    recyclerView.layoutManager=LinearLayoutManager(this)
    recyclerView.adapter=adapter

    fetchFaqs()

    //fetchContact()

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }




  fun fetchFaqs(){
    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"

    val call = serviceGenerator.getFAQList(authorization)

    call.enqueue(object : retrofit2.Callback<MutableList<FAQItem>> {
      @SuppressLint("NotifyDataSetChanged")
      override fun onResponse(
        call: Call<MutableList<FAQItem>>,
        response: Response<MutableList<FAQItem>>
      ) {
        if (response.isSuccessful) {
          if (response.isSuccessful) {
            val notifications = response.body()
            if (notifications != null) {
              //FAQItem.addAll(notifications)
              faqList.addAll(notifications)
              binding.recyclerFAQs.adapter?.notifyDataSetChanged()
            } else {
              // Handle empty response
            }
          } else {
            // Handle API error
          }
        }
      }

      override fun onFailure(call: Call<MutableList<FAQItem>>, t: Throwable) {
        // Handle network failures or other errors
        Toast.makeText(this@HelpActivity, "Error fetching data", Toast.LENGTH_SHORT).show()
      }
    })
  }




  fun fetchContact(){
    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"

    val call = serviceGenerator.getContact(authorization)

    call.enqueue(object : retrofit2.Callback<MutableList<ContactUs>> {
      override fun onResponse(
        call: Call<MutableList<ContactUs>>,
        response: Response<MutableList<ContactUs>>
      ) {
        if (response.isSuccessful) {
            val contactresponse = response.body()
            if (contactresponse != null) {
              binding.phonenumber.text=contactresponse[0].helpline_number
              binding.mail.text=contactresponse[0].email
            }
          }
      }

      override fun onFailure(call: Call<MutableList<ContactUs>>, t: Throwable) {
        // Handle network failures or other errors
        Toast.makeText(this@HelpActivity, "Error fetching data", Toast.LENGTH_SHORT).show()
      }
    })
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }


  companion object {
    const val TAG: String = "HELP_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HelpActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
