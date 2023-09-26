package com.starmakers.app.modules.artistrequestinfo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoAdapter
import com.starmakers.app.responses.ArtistRequestById
import com.starmakers.app.responses.MyStudioRequest
import com.starmakers.app.responses.SelectionListResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response

class ArtistRequestInfo : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_request_info)
        sessionManager=SessionManager(this)

        val artistId=intent.getIntExtra("profileDataId",-1)
        getMyArtistRequests(artistId)
    }


    private fun getMyArtistRequests(studioId:Int){

        val serviceGenerator= ApiManager.apiInterface
        val accessToken=sessionManager.fetchAuthToken()
        val authorization="Token $accessToken"
        val call=serviceGenerator.get_user_list_by_id(authorization,studioId)

        call.enqueue(object : retrofit2.Callback<ArtistRequestById>{
            override fun onResponse(
                call: Call<ArtistRequestById>,
                response: Response<ArtistRequestById>
            ) {
                val customerResponse=response.body()
                val toolName=findViewById<TextView>(R.id.txtChikkanna)
                val name=findViewById<TextView>(R.id.txtName1)
                val age=findViewById<TextView>(R.id.txtAge1)
                val height=findViewById<TextView>(R.id.txtHeight1)
                val weight=findViewById<TextView>(R.id.txtWeight1)
                val natureofartist=findViewById<TextView>(R.id.txtNatureofArtis1)
                val experience=findViewById<TextView>(R.id.txtExperience1)
                val totalnoofmovies=findViewById<TextView>(R.id.txtTotalnumberof1)
                val mobileNumber=findViewById<TextView>(R.id.txtContactNumber1)
                val image=findViewById<ImageView>(R.id.imageRectangle112)
                val btnRequestse=findViewById<AppCompatButton>(R.id.btnBooked)


                // Define the corner radius in pixels (converted from dp)
                val cornerRadiusInPixels = 15 // Change to your dimension resource

                // Create a RequestOptions object with the RoundedCorners transformation
                val requestOptions = RequestOptions()
                    .transform(RoundedCorners(cornerRadiusInPixels))
                if(customerResponse!=null)
                {

                    name.text=customerResponse.artist_name
                    toolName.text=customerResponse.artist_name
                    age.text=customerResponse.age
                    height.text=customerResponse.height
                    weight.text=customerResponse.weight
                    natureofartist.text=customerResponse.category_name
                    experience.text=customerResponse.total_experience
                    totalnoofmovies.text=customerResponse.total_no_of_movies
                    mobileNumber.text=customerResponse.mobile_number





                    val isBooked=customerResponse.booking_status

                    if(isBooked=="pending"){
                        btnRequestse.text="Pending"
                    }else{
                        btnRequestse.text="Booked"
                    }

                    val file = customerResponse.artist_pictures[0].artist_picture // Assuming postModel.profile is a File object

                    val imgUrl= file.let { ApiManager.getImageUrl(it) }
//                    Picasso.get()
//                        .load(imgUrl)
//                        .into(image)


                    Glide.with(this@ArtistRequestInfo)
                        .load(imgUrl) // Replace with your image URL or resource ID
                        .apply(requestOptions)
                        .into(image)

                }

            }

            override fun onFailure(call: Call<ArtistRequestById>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }

    })

}}