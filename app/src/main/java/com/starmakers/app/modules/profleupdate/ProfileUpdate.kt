package com.starmakers.app.modules.profleupdate

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.responses.RequestAudition
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class ProfileUpdate : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager


    private lateinit var progressBar: ProgressBar

    private var name:String=""
    private var height:String=""
    private var weight:String=""
    private var location:String=""
    private var profile_picture:String=""

    private val pickImage = 100
    private lateinit var imageUri: Uri
    private lateinit var nimage: ImageView
    private lateinit var updatedimagefile: File


    private var profilePictureUrl: String = ""

    var multipartImage: MultipartBody.Part? = null
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_update)
        sessionManager= SessionManager(this)
        window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)

        fetchData()

        progressBar=findViewById(R.id.progressBar)

        val backImage:ImageView=findViewById(R.id.imageArrowleft)

        backImage.setOnClickListener {
            this.finish()
        }

        val editProfileImage:ImageView=findViewById(R.id.editProfileImageView)
        editProfileImage.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        val button=findViewById<AppCompatButton>(R.id.btnUpdate)
        button.setOnClickListener{
            val editname=findViewById<EditText>(R.id.etName)
            name=editname.text.toString()


            var editheight=findViewById<EditText>(R.id.etHeight1)
            height=editheight.text.toString()


            val editWeight=findViewById<EditText>(R.id.etWeight1)
            weight=editWeight.text.toString()


            val editlocation=findViewById<EditText>(R.id.etLocation1)
            location=editlocation.text.toString()


            updateData()

            progressBar.visibility=View.VISIBLE

        }

    }


    private fun fetchData(){
        val serviceGenerator= ApiManager.apiInterface
        val accessToken=sessionManager.fetchAuthToken()
        val authorization="Token $accessToken"
        val call=serviceGenerator.requestAudition(authorization)

        call.enqueue(object : retrofit2.Callback<RequestAudition>{
            override fun onResponse(
                call: Call<RequestAudition>,
                response: Response<RequestAudition>
            ) {
                val customerResponse=response.body()

                val newName=findViewById<EditText>(R.id.etName)
                val newMobileNumber=findViewById<TextView>(R.id.etMobileNo)
                val newEmail=findViewById<TextView>(R.id.etEmail)
                val newHeight=findViewById<EditText>(R.id.etHeight1)
                val newWeight=findViewById<EditText>(R.id.etWeight1)
                val profileImage=findViewById<ImageView>(R.id.imageEllipseSeven)
                val newLocation=findViewById<EditText>(R.id.etLocation1)
                nimage=findViewById(R.id.imageEllipseSeven)


                customerResponse?.data?.let {
                    newName.setText(it.name?:it.artistName)
                    newMobileNumber.text = it.mobileNumber
                    newEmail.text = it.email
                    newHeight.setText(it.height)
                    newWeight.setText(it.weight)
                    newLocation.setText(it.city)

                    profilePictureUrl =  it.profile ?: it.artistPictures.get(0).artistPicture ?:""

                    if (profilePictureUrl.isNotEmpty()) {
                        Picasso.get()
                            .load(profilePictureUrl)
                            .placeholder(R.drawable.rounded_profile_image)
                            .transform(CircleTransformation())
                            .into(profileImage)
                    }
                }
            }

            override fun onFailure(call: Call<RequestAudition>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }
        })
    }


    private fun updateData(){
            val map: MutableMap<String, RequestBody> = mutableMapOf()
        val name=createPartFromString(name)
        val height=createPartFromString(height)
        val weight=createPartFromString(weight)
        val location=createPartFromString(location)

        //updatedimagefile=getFile(this,imageUri)

        map.put("name",name)
        map.put("height",height)
        map.put("weight",weight)
        map.put("location",location)



        CoroutineScope(Dispatchers.Main).launch {

            // Use the existing profile picture file if no new image is selected
            updatedimagefile = if (::imageUri.isInitialized) {
                getFile(this@ProfileUpdate, imageUri)
            } else {
                downloadFileFromUrl(profilePictureUrl)
            }


            val requestFile: RequestBody = RequestBody.create(
                "image/jpg".toMediaType(),
                updatedimagefile
            )
            multipartImage =
                MultipartBody.Part.createFormData(
                    "profile_picture",
                    updatedimagefile.getName(),
                    requestFile
                )

            val serviceGenerator = ApiManager.apiInterface
            val accessToken = sessionManager.fetchAuthToken()
            val authorization = "Token $accessToken"
            val call = serviceGenerator.profileUpdate(authorization, map, multipartImage!!)
            call.enqueue(object : retrofit2.Callback<ProfileResponse> {

                override fun onResponse(
                    call: Call<ProfileResponse>,
                    response: Response<ProfileResponse>,
                ) {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
                        val profileResponse = response.body()
//                   if(profileResponse!=null){
//                       val name=findViewById<EditText>(R.id.etGroupTwentyEight11)
//                       val email=findViewById<EditText>(R.id.etGroupTwentyEight111)
//
//                       name.setText(profileResponse.username)
//                       email.setText(profileResponse.email)
//                   }

                        Toast.makeText(
                            this@ProfileUpdate,
                            "Profile updated successfully",
                            Toast.LENGTH_SHORT
                        ).show()

                        profileUpdateSuccess()
                    } else {
                        // Handle API error
                        Toast.makeText(
                            this@ProfileUpdate,
                            "Failed to update profile",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                    // Handle network failures or other errors
                    Toast.makeText(this@ProfileUpdate, "Error fetching data", Toast.LENGTH_SHORT)
                        .show()
                    progressBar.visibility = View.GONE
                }
            })

        }

    }

    fun profileUpdateSuccess(){
        super.onBackPressed()
    }



    private fun createPartFromString(text: String): RequestBody {
        return RequestBody.create("text/plain".toMediaTypeOrNull(), text)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data!!
            imageUri.let {
                nimage.setImageURI(it)
                updatedimagefile = getFile(this, it)
            }
        }
    }

    @Throws(IOException::class)
    fun getFile(context: Context, uri: Uri): File {
        val destinationFilename =
            File(context.filesDir.path + File.separatorChar + queryName(context, uri))
        try {
            context.contentResolver.openInputStream(uri).use { ins ->
                createFileFromStream(
                    ins!!,
                    destinationFilename
                )
            }
        } catch (ex: Exception) {
            Log.e("Save File", ex.message!!)
            ex.printStackTrace()
        }
        return destinationFilename
    }

    fun createFileFromStream(ins: InputStream, destination: File?) {
        try {
            FileOutputStream(destination).use { os ->
                val buffer = ByteArray(4096)
                var length: Int
                while (ins.read(buffer).also { length = it } > 0) {
                    os.write(buffer, 0, length)
                }
                os.flush()
            }
        } catch (ex: Exception) {
            Log.e("Save File", ex.message!!)
            ex.printStackTrace()
        }
    }

    private fun queryName(context: Context, uri: Uri): String {
        var name = ""

        val returnCursor = context.contentResolver.query(uri, null, null, null, null)

        returnCursor?.use { cursor ->
            if (cursor.moveToFirst()) {
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                name = cursor.getString(nameIndex)
            }
        }

        return name
//        val returnCursor = context.contentResolver.query(uri, null, null, null, null)!!
//        val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
//        returnCursor.moveToFirst()
//        val name = returnCursor.getString(nameIndex)
//        returnCursor.close()
//        return name
    }


    private suspend fun downloadFileFromUrl(url: String): File = withContext(Dispatchers.IO) {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.connect()

        val inputStream = connection.inputStream
        val outputFile = File(filesDir, "temp_image.jpg")
        FileOutputStream(outputFile).use { output ->
            val buffer = ByteArray(4096)
            var bytesRead: Int
            while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                output.write(buffer, 0, bytesRead)
            }
        }
        inputStream.close()
        connection.disconnect()
        outputFile
    }

}