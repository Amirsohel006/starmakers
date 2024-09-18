package com.starmakers.app.modules.frame316.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrame316Binding
import com.starmakers.app.modules.frame315.ui.Frame315Activity
import com.starmakers.app.modules.frame316.`data`.viewmodel.Frame316VM
import com.starmakers.app.modules.request.ui.RequestActivity
import com.starmakers.app.modules.requestone.ui.RequestOneActivity
import com.starmakers.app.modules.selectionlisttwo.ui.Listrectangle140Adapter
import com.starmakers.app.modules.studiobookong1.ui.StudioBookong1Activity
import com.starmakers.app.responses.PostReponses
import com.starmakers.app.responses.RequestPostResponse
import com.starmakers.app.responses.SelectionListResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.String
import kotlin.Unit

class Frame316Activity : BaseActivity<ActivityFrame316Binding>(R.layout.activity_frame_316) {
  private val viewModel: Frame316VM by viewModels<Frame316VM>()
  private lateinit var sessionManager: SessionManager

  @RequiresApi(Build.VERSION_CODES.N)
  override fun onInitialized(): Unit {
    sessionManager=SessionManager(this)
    viewModel.navArguments = intent.extras?.getBundle("bundle")


    val requestId = intent.getIntExtra("requestId",-1)
    var fromdate=binding.etGroup150.text.toString()
    var todate=binding.etGroup151.text.toString()



    val imageView = binding.imageview // Replace 'imageView' with the ID of your ImageView in your layout XML.
    val imageView1=binding.imageview1


    binding.imageClose.setOnClickListener {
      this.finish()
    }

    imageView.setOnClickListener {
      showDatePickerDialog { selectedDate ->
        fromdate = selectedDate
        binding.etGroup150.setText(fromdate)
      }
    }

    imageView1.setOnClickListener {
      showDatePickerDialog { selectedDate ->
        todate = selectedDate
        binding.etGroup151.setText(todate)
      }
    }
    val button=binding.btnRequestStudio

    button.setOnClickListener {
      postData(requestId,fromdate,todate)
    }



    binding.frame316VM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }


  @RequiresApi(Build.VERSION_CODES.N)
  private fun showDatePickerDialog(onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
      val selectedDate = Calendar.getInstance()
      selectedDate.set(selectedYear, selectedMonth, selectedDay)
      val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
      val formattedDate = dateFormat.format(selectedDate.time)
      onDateSelected(formattedDate)
    }, year, month, day)

    datePickerDialog.show()
  }

  override fun setUpClicks(): Unit {
    binding.btnRequestStudio.setOnClickListener {
      val destIntent = Frame315Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }


  private fun postData(auditionId:Int,fromDate:String,toDate:String){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"

    // Create a RequestPostResponse object with your data
    val requestPost = RequestPostResponse(studio = auditionId, from_date = fromDate, to_date = toDate)

    // Create a list and add the requestPost object to it
    val call=serviceGenerator.postRequestStudio(authorization,requestPost)

    call.enqueue(object : retrofit2.Callback<ResponseBody>{
      @SuppressLint("SuspiciousIndentation")
      override fun onResponse(
        call: Call<ResponseBody>,
        response: Response<ResponseBody>
      ) {
        if(response.isSuccessful){
        Toast.makeText(this@Frame316Activity, "Request Sent Successfully", Toast.LENGTH_SHORT).show()
          val i=Intent(this@Frame316Activity, RequestActivity::class.java)
          startActivity(i)
          finish()

        }

      }

      override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }
  companion object {
    const val TAG: String = "FRAME316ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame316Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
