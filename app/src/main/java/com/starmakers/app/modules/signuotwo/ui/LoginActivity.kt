package com.starmakers.app.modules.signuotwo.ui

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
import com.starmakers.app.databinding.ActivitySignUoTwoBinding
import com.starmakers.app.modules.signuofour.ui.SignUoFourActivity
import com.starmakers.app.modules.signuothree.ui.LoginOTPActivity
import com.starmakers.app.modules.signuotwo.`data`.viewmodel.SignUoTwoVM
import com.starmakers.app.responses.LoginResponse
import com.starmakers.app.service.ApiInterface
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivitySignUoTwoBinding>(R.layout.activity_sign_uo_two) {
  private val viewModel: SignUoTwoVM by viewModels<SignUoTwoVM>()


  private lateinit var sharedPreferences: SharedPreferences
  private lateinit var apiService: ApiInterface
  private lateinit var sessionManager: SessionManager
  private var mobile:String=""

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    apiService= ApiManager.apiInterface
    sessionManager= SessionManager(this)


    binding.btnLogin.setOnClickListener{
      mobile = binding.editTextMobileNumber.text.toString()

      if (isValidMobileNumber(mobile)) {
        getOtp(mobile)
        binding.progressBar.visibility = View.VISIBLE
      } else {
        Toast.makeText(this, "Please enter a valid mobile number", Toast.LENGTH_SHORT).show()
      }
    }


    binding.signUoTwoVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.white)
  }


  private fun isValidMobileNumber(mobile: String): Boolean {
    // Check if the mobile number is exactly 10 digits and contains only digits
    return mobile.length == 10 && mobile.all { it.isDigit() }
  }

  override fun setUpClicks(): Unit {
    binding.txtSignup.setOnClickListener {
      val destIntent = SignUoFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }


  private fun getOtp(mobile: String){
    val call=apiService.getOtp(mobile)
    call.enqueue(object : Callback<LoginResponse> {
      override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        binding.progressBar.visibility= View.GONE
        if (response.isSuccessful) {

          val loginResponse = response.body()
          if (loginResponse != null) {
            //Toast.makeText(this@LoginActivity, "Otp Sent Successfully: ${loginResponse.otp}", Toast.LENGTH_LONG).show()
            navigateToNextPage()
            finishAffinity()
          } else {
            Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility= View.GONE
          }
        }  else {
          if (response.code() == 404 ) {
            binding.progressBar.visibility= View.GONE
            val errorBody = response.errorBody()?.string()
            if (!errorBody.isNullOrEmpty()) {
              try {
                val jsonObject = JSONObject(errorBody)
                val errorMessage = jsonObject.getString("error")
                Toast.makeText(this@LoginActivity, errorMessage, Toast.LENGTH_SHORT).show()
              } catch (e: JSONException) {
                Toast.makeText(this@LoginActivity, "User not found or not registered", Toast.LENGTH_SHORT).show()
              }
            } else {
              Toast.makeText(this@LoginActivity, "User not found or not registered", Toast.LENGTH_SHORT).show()
            }
          } else {
            Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
          }
        }
      }
      override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
        Toast.makeText(this@LoginActivity, "Login failed: ${t.message}", Toast.LENGTH_SHORT).show()
        binding.progressBar.visibility= View.GONE
      }
    })
  }

  private fun navigateToNextPage() {
    val i=Intent(this,LoginOTPActivity::class.java)
    i.putExtra("mobileNumber",mobile)
    startActivity(i)
  }



  companion object {
    const val TAG: String = "SIGN_UO_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LoginActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
