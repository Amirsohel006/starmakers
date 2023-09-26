package com.starmakers.app.modules.artistbookingativity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.databinding.ActivityArtistBookongBinding
import com.starmakers.app.extensions.isText
import com.starmakers.app.modules.requestone.ui.RequestOneActivity
import com.starmakers.app.responses.RequestArtist
import com.starmakers.app.responses.RequestPostResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Locale

class ArtistBookingAcitivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager=SessionManager(this)
        setContentView(R.layout.activity_artist_booking_acitivity)

        val artistId=intent.getIntExtra("artistId",-1)

        val imageView = findViewById<ImageView>(R.id.imageview)
        val fromdate1 = findViewById<TextView>(R.id.etGroup150)
        val btnRequest = findViewById<AppCompatButton>(R.id.btnRequestStudio)

        var selectedDate: String? = null // Initialize the selectedDate variable

        imageView.setOnClickListener {
            showDatePickerDialog { date ->
                // Set the selected date and update the TextView
                selectedDate = date
                fromdate1.text = date
            }
        }

        btnRequest.setOnClickListener {
            // Check if selectedDate is not null before passing it to the postData function
            if (selectedDate != null) {
                postData(artistId, selectedDate!!)
            } else {
                // Handle the case where a date hasn't been selected
                // You can show an error message or perform appropriate actions here
            }
        }


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


    private fun postData(artistId:Int,booking_date:String){
        val serviceGenerator= ApiManager.apiInterface
        val accessToken=sessionManager.fetchAuthToken()
        val authorization="Token $accessToken"

        // Create a RequestPostResponse object with your data
        val requestPost = RequestArtist(artist = artistId, booking_date = booking_date)

        // Create a list and add the requestPost object to it
        val call=serviceGenerator.postArtistRequest(authorization,requestPost)

        call.enqueue(object : retrofit2.Callback<ResponseBody>{
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if(response.isSuccessful){

                    Toast.makeText(this@ArtistBookingAcitivity,"Artist Request Sent Successfully",Toast.LENGTH_SHORT).show()

                    val i=Intent(this@ArtistBookingAcitivity,RequestOneActivity::class.java)
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


}