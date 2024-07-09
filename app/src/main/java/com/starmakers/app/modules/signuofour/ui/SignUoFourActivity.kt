package com.starmakers.app.modules.signuofour.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySignUoFourBinding
import com.starmakers.app.modules.signuo.ui.SignUoActivity
import com.starmakers.app.modules.signuofour.`data`.viewmodel.SignUoFourVM
import com.starmakers.app.modules.signuotwo.ui.LoginActivity
import com.starmakers.app.responses.LoginResponse
import com.starmakers.app.service.ApiInterface
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class SignUoFourActivity : BaseActivity<ActivitySignUoFourBinding>(R.layout.activity_sign_uo_four) {
  private val viewModel: SignUoFourVM by viewModels<SignUoFourVM>()

  private lateinit var sharedPreferences: SharedPreferences
  private lateinit var apiService: ApiInterface
  private lateinit var sessionManager: SessionManager

  private var mobile:String=""

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoFourVM = viewModel

    apiService= ApiManager.apiInterface
    sessionManager= SessionManager(this)
    binding.btnSignup.setOnClickListener{
        mobile=binding.txtEnterMobilenu.text.toString()

      if (isValidMobileNumber(mobile)) {
        getOtp(mobile)
        binding.progressBar.visibility = View.VISIBLE
      } else {
        Toast.makeText(this, "Please enter a valid mobile number", Toast.LENGTH_SHORT).show()
      }
    }
    window.statusBarColor= ContextCompat.getColor(this,R.color.white)
  }

  private fun isValidMobileNumber(mobile: String): Boolean {
    // Check if the mobile number is exactly 10 digits and contains only digits
    return mobile.length == 10 && mobile.all { it.isDigit() }
  }

  override fun setUpClicks(): Unit {
//    binding.btnSignup.setOnClickListener {
//      val destIntent = SignUoActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.txtLogin.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }



  private fun getOtp(mobile: String){
    val call=apiService.getSignUpOTP(mobile)
    call.enqueue(object : Callback<LoginResponse> {
      override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        if (response.isSuccessful) {
          binding.progressBar.visibility = View.GONE
          val loginResponse = response.body()
          if (loginResponse != null) {
            //Toast.makeText(this@SignUoFourActivity, "Otp Sent Successfully: ${loginResponse.otp}", Toast.LENGTH_LONG).show()
            navigateToNextPage()
            finish()
          } else {
            Toast.makeText(this@SignUoFourActivity, "Login failed", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.GONE
          }
        } else if (response.code() == 401) {
          // Handle invalid OTP case
          Toast.makeText(
            this@SignUoFourActivity,
            "User is Already Registered, Please LogIN!",
            Toast.LENGTH_SHORT
          ).show()
          binding.progressBar.visibility = View.GONE
        } else {
          Toast.makeText(this@SignUoFourActivity, "Login failed", Toast.LENGTH_SHORT).show()
          binding.progressBar.visibility = View.GONE
        }
      }
      override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
        Toast.makeText(this@SignUoFourActivity, "Login failed: ${t.message}", Toast.LENGTH_SHORT).show()
        binding.progressBar.visibility=View.GONE
      }
    })
  }


  private fun navigateToNextPage() {
    val i=Intent(this, SignUoActivity::class.java)
    i.putExtra("mobileNumber",mobile)
    startActivity(i)
  }


  companion object {
    const val TAG: String = "SIGN_UO_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
