package com.starmakers.app.modules.regstrationdetails.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityRegstrationDetailsBinding
import com.starmakers.app.modules.frametwentyfour.ui.FrameTwentyfourActivity
import com.starmakers.app.modules.regstrationdetails.`data`.model.Listellipsetwentysix2RowModel
import com.starmakers.app.modules.regstrationdetails.`data`.model.Listpaypalone2RowModel
import com.starmakers.app.modules.regstrationdetails.`data`.viewmodel.RegstrationDetailsVM
import com.starmakers.app.responses.PaymentRequest
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.service.ApiInterface
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.io.IOException
import kotlin.Int
import kotlin.String
import kotlin.Unit

class RegstrationDetailsActivity :
    BaseActivity<ActivityRegstrationDetailsBinding>(R.layout.activity_regstration_details) {
  private val viewModel: RegstrationDetailsVM by viewModels<RegstrationDetailsVM>()


  private lateinit var sessionManager: SessionManager

  private lateinit var userId:String
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")

    sessionManager= SessionManager(this)


    fetchData()






    binding.btnPayAndRegisterOne.setOnClickListener {
      initiatePayment()
      binding.progressBar.visibility=View.VISIBLE
    }

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
    binding.regstrationDetailsVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }


  private fun fetchData(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getProfile(authorization)

    call.enqueue(object : retrofit2.Callback<ProfileResponse>{
      override fun onResponse(
        call: Call<ProfileResponse>,
        response: Response<ProfileResponse>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){

          userId=customerResponse.id.toString()

        }
      }

      override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }

  private fun initiatePayment() {
    val user_id = userId
    val amount =binding.txtRsCounter1.text.toString()
//    val serviceGenerator = APIManager.apiInterface
    val apiInterface: ApiInterface = ApiManager.apiInterface
    val accestoken = sessionManager.fetchAuthToken()
    val paymentRequest = PaymentRequest(user_id!!, amount)
    //val refreshtoken = sessionManager.fetchRefreshToken().toString()
    //val authorization = "Bearer $accestoken"
    val call = apiInterface.initiatePayment(paymentRequest)


    call.enqueue(object : retrofit2.Callback<ResponseBody> {

      override fun onResponse(
        call: Call<ResponseBody>,
        response: Response<ResponseBody>,
      ) {
        binding.progressBar.visibility=View.GONE
        if (response.isSuccessful) {
          binding.progressBar.visibility=View.GONE
          val contentType = response.headers()["Content-Type"]
          if (contentType != null && contentType.startsWith("application/json")) {
            try {
              val paymentResponseJson = response.body()?.string()
              // Parse paymentResponseJson using Gson if needed
            } catch (e: IOException) {
              e.printStackTrace()
            }
          } else {
            // Handle non-JSON response (HTML, in this case)
            val paymentHtml = response.body()?.string()
            showPaymentWebView(paymentHtml)
          }
        } else {
          binding.progressBar.visibility=View.GONE
          Log.d("Response Error", response.message())
          Toast.makeText(this@RegstrationDetailsActivity, "Payment Failed", Toast.LENGTH_SHORT).show()
        }
      }

      override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }


  // Add this JavaScript function inside your HTML content



  @SuppressLint("SetJavaScriptEnabled")
  private fun showPaymentWebView(htmlContent: String?) {
    val webView = WebView(this)
    val webSettings = webView.settings
    webSettings.javaScriptEnabled = true

    webView.isFocusable = true
    webView.isFocusableInTouchMode = true


    val layoutParams = ViewGroup.LayoutParams(
      ViewGroup.LayoutParams.MATCH_PARENT,
      ViewGroup.LayoutParams.MATCH_PARENT
    )
    webView.layoutParams = layoutParams

    webView.loadDataWithBaseURL(null, htmlContent!!, "text/html", "UTF-8", null)

    webView.webViewClient = object : WebViewClient() {
      @Deprecated("Deprecated in Java")
      override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        return super.shouldOverrideUrlLoading(view, url)
      }
    }

    webView.webViewClient = object : WebViewClient() {
      override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        // Execute your JavaScript code after the page has finished loading
        webView.loadUrl("javascript:focusOnEditText();")
      }
    }


    webView.postDelayed({
      webView.loadUrl("javascript:focusOnEditText();")
    }, 500)

    val dialog = AlertDialog.Builder(this)
      .setView(webView)
      .setPositiveButton("Close") { _, _ -> }
      .create()


    dialog.show()


    //if you wanted to enable the keyboard at webview you need to implement this after dialogue
    dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
    dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)


  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnPayAndRegisterOne.setOnClickListener {
      val destIntent = FrameTwentyfourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListpaypalone(
    view: View,
    position: Int,
    item: Listpaypalone2RowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListellipsetwentysix(
    view: View,
    position: Int,
    item: Listellipsetwentysix2RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "REGSTRATION_DETAILS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegstrationDetailsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
