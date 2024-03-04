package com.starmakers.app.modules.signuo.ui

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySignUoBinding
import com.starmakers.app.modules.signuo.`data`.viewmodel.SignUoVM
import com.starmakers.app.modules.signuoone.ui.SignUoOneActivity
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.starmakers.app.modules.homecontainer.ui.HomeContainerActivity
import com.starmakers.app.responses.LoginResponse
import com.starmakers.app.service.ApiInterface
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import com.starmakers.app.service.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.String
import kotlin.Unit

class SignUoActivity : BaseActivity<ActivitySignUoBinding>(R.layout.activity_sign_uo) {
  private var otpViewOtpviewBroadcastReceiver: OtpViewOtpviewBroadcastReceiver? = null

  private lateinit var apiService: ApiInterface
  private lateinit var sessionManager: SessionManager
  private lateinit var sharedPreferences: SharedPreferences

  private var mobile:String=""

  val getActivityResult: ActivityResultLauncher<Intent> =
      registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
  ActivityResultCallback {
    val message = it.data?.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE)
    getOtpFromMessage(message!!)
    })


    private val viewModel: SignUoVM by viewModels<SignUoVM>()

    override fun onInitialized(): Unit {

      TokenManager.initialize(this)
      sessionManager= SessionManager(this)
      viewModel.navArguments = intent.extras?.getBundle("bundle")
      startSmartUserConsent()

      sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)


      mobile=intent.getStringExtra("mobileNumber")!!

      binding.txtLanguage.text=mobile

      val isFirstTime = sharedPreferences.getBoolean("is_first_time", true)
      if (isFirstTime) {
        sharedPreferences.edit().clear().apply()
        sharedPreferences.edit().putBoolean("is_first_time", false).apply()
      } else {
        val accessToken = sharedPreferences.getString("access_token", null)
        if (accessToken != null) {
          navigateToNextPage()
        }
      }

      apiService= ApiManager.apiInterface

      binding.btnVerify.setOnClickListener {
        val enteredOtp = binding.otpViewOtpview.text.toString()
        if (enteredOtp.length == 6) {
          // OTP is valid, so post it to the API
          login(enteredOtp)
          binding.progressBar.visibility=View.VISIBLE
        } else {
          // Handle invalid OTP length
        }
      }



      binding.signUoVM = viewModel
      window.statusBarColor= ContextCompat.getColor(this,R.color.white)
    }


  private fun getResendSignUpOtp(mobile: String){
    val call=apiService.getSignUpOTP(mobile)
    call.enqueue(object : Callback<LoginResponse> {
      override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        if (response.isSuccessful) {
          binding.progressBar.visibility=View.GONE
          val loginResponse = response.body()
          if (loginResponse != null) {
            Toast.makeText(this@SignUoActivity, "Otp Sent Successfully: ${loginResponse.otp}", Toast.LENGTH_LONG).show()
          } else {
            Toast.makeText(this@SignUoActivity, "Login failed", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility=View.GONE
          }
        } else {
          Toast.makeText(this@SignUoActivity, "Login failed", Toast.LENGTH_SHORT).show()
          binding.progressBar.visibility=View.GONE
        }
      }
      override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
        Toast.makeText(this@SignUoActivity, "Login failed: ${t.message}", Toast.LENGTH_SHORT).show()
        binding.progressBar.visibility=View.GONE
      }
    })
  }

  private fun navigateToNextPage() {
    val i= SignUoOneActivity.getIntent(this,null)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(i)
  }
    override fun onStop(): Unit {
      super.onStop()
      unregisterReceiver(otpViewOtpviewBroadcastReceiver)
    }

    override fun onStart(): Unit {
      super.onStart()
      registerBroadcastReceiver()
    }


  private  fun login(otp: String) {
    val call = apiService.verifySignUpOtp(otp)
    call.enqueue(object : Callback<LoginResponse> {
      override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        if (response.isSuccessful) {
          binding.progressBar.visibility=View.GONE
          val loginResponse = response.body()
          if (loginResponse != null) {
//            val accessToken = loginResponse.access_token
//            TokenManager.setTokens(accessToken)
//            sessionManager.saveAuthToken(accessToken)
            Toast.makeText(this@SignUoActivity, "OTP Verified Successfully", Toast.LENGTH_SHORT).show()
            navigateToNextPage()
          } else {
            Toast.makeText(this@SignUoActivity, "Login failed", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility=View.GONE
          }
        } else {
          Toast.makeText(this@SignUoActivity, "Login failed", Toast.LENGTH_SHORT).show()
          binding.progressBar.visibility=View.GONE
        }
      }
      override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
        Toast.makeText(this@SignUoActivity, "Login failed: ${t.message}", Toast.LENGTH_SHORT).show()
        binding.progressBar.visibility=View.GONE
      }
    })
  }
    override fun setUpClicks(): Unit {
binding.txtResendOTP.setOnClickListener {
  getResendSignUpOtp(mobile)
  binding.progressBar.visibility=View.VISIBLE
}
    }

    private fun startSmartUserConsent(): Unit {
      val client = SmsRetriever.getClient(this)
      client.startSmsUserConsent(null)
    }

    private fun registerBroadcastReceiver(): Unit {
      otpViewOtpviewBroadcastReceiver = OtpViewOtpviewBroadcastReceiver()
      otpViewOtpviewBroadcastReceiver?.otpBroadcastReceiverListener =
      object : OtpViewOtpviewBroadcastReceiver.OtpBroadcastListener {
        override fun onSuccess(intent: Intent?) {
          getActivityResult.launch(intent)
        }
        override fun onFailure() {

        }
      }
      val intentFilter = IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
      registerReceiver(otpViewOtpviewBroadcastReceiver, intentFilter)
    }

    private fun getOtpFromMessage(message: String): Unit {
      val otpPattern: Pattern = Pattern.compile("(|^)\\d{6}")
      val matcher: Matcher = otpPattern.matcher(message)
      if (matcher.find()) {
        binding.otpViewOtpview?.setText(matcher.group(0))
      }
    }

    companion object {
      const val TAG: String = "SIGN_UO_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, SignUoActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
