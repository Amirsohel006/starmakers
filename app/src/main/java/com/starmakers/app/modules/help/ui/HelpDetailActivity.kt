package com.starmakers.app.modules.help.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.responses.FAQItem
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response

class HelpDetailActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_detail)

        sessionManager=SessionManager(this)

        val notificationId = intent.getIntExtra("faqId", -1)

        fetchNotificationDetails(notificationId)

        window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
    }


    private fun fetchNotificationDetails(faqId: Int){
        val serviceGenerator = ApiManager.apiInterface
        val accessToken = sessionManager.fetchAuthToken()
        val authorization = "Token $accessToken"

        val call = serviceGenerator.getFAQItem(authorization,faqId)

        call.enqueue(object : retrofit2.Callback<FAQItem> {
            override fun onResponse(
                call: Call<FAQItem>,
                response: Response<FAQItem>
            ) {
                if (response.isSuccessful) {
                    val profileResponse = response.body()

                    val title:TextView=findViewById(R.id.title1)
                    val description:TextView=findViewById(R.id.description1)
                    profileResponse?.let {
                       title.text=profileResponse.question
                        description.text=profileResponse.answer
                        }

                }
            }

            override fun onFailure(call: Call<FAQItem>, t: Throwable) {
                // Handle network failures or other errors
                Toast.makeText(this@HelpDetailActivity, "Error fetching data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}