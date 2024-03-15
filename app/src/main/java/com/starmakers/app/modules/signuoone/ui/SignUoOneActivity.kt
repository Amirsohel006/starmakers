package com.starmakers.app.modules.signuoone.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySignUoOneBinding
import com.starmakers.app.modules.signuoone.`data`.viewmodel.SignUoOneVM
import com.starmakers.app.modules.signuotwo.ui.LoginActivity
import com.starmakers.app.responses.SignUpResponse
import com.starmakers.app.service.ApiInterface
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import kotlin.String
import kotlin.Unit

class SignUoOneActivity : BaseActivity<ActivitySignUoOneBinding>(R.layout.activity_sign_uo_one) {
  private val viewModel: SignUoOneVM by viewModels<SignUoOneVM>()

  private lateinit var apiService: ApiInterface
  private lateinit var sessionManager: SessionManager
  private val pickImage = 100
  private var imageUri: Uri? = null



  var name: String=""
  var mobilenumber: String=""
  var city: String=""
  var pincode: String=""
  var email: String=""
  lateinit var profileImageView: ImageView
  private lateinit var file: File
  var profileImage:String=""
  var uploadedFileName:String=""

  var multipartImage: MultipartBody.Part? = null


  override fun onInitialized(): Unit {
    sessionManager = SessionManager(this)
    apiService= ApiManager.apiInterface

    profileImageView=binding.profilePic

    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoOneVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.white)
  }

  override fun setUpClicks(): Unit {
    binding.btnComplete.setOnClickListener {
//      val destIntent = HomeContainerActivity.getIntent(this, null)
//      startActivity(destIntent)

      name=binding.etGroupName.text.toString()
      mobilenumber=binding.etGroupMobileNumber.text.toString()
      city=binding.etGroupCity.text.toString()
      pincode=binding.etGroupPincode.text.toString()
      email=binding.etGroupEmail.text.toString()

      // Check if any field is empty
      if (TextUtils.isEmpty(name) || TextUtils.isEmpty(mobilenumber) || TextUtils.isEmpty(city) || TextUtils.isEmpty(pincode) || TextUtils.isEmpty(email) || imageUri == null) {
        // Display an error message
        Toast.makeText(this@SignUoOneActivity, "Please fill in all the required fields and select a profile picture.", Toast.LENGTH_SHORT).show()
      } else {
        signUp() // Call signUp function if all fields are filled
        binding.progressBar.visibility= View.VISIBLE
      }


    }

    binding.ivEdit.setOnClickListener{
      val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
      startActivityForResult(gallery, pickImage)
    }
  }


  private  fun signUp(
  ) {
    val map: MutableMap<String, RequestBody> = mutableMapOf()
    val name = createPartFromString(name)
    val email = createPartFromString(email)
    val city=createPartFromString(city)
    val pincode=createPartFromString(pincode)
    val mobilenumber=createPartFromString(mobilenumber)

    map.put("name", name)
    map.put("email", email)
    map.put("city", city)
    map.put("pin_code", pincode)
    map.put("mobile_number", mobilenumber)


    // Parsing any Media type file
    //file= imageUri.path?.let { File(it) }!!
    //val file = File(profileImage)
    val requestFile: RequestBody = RequestBody.create(
      "image/jpg".toMediaType(),
      file
    )

    multipartImage =
      MultipartBody.Part.createFormData("profile", file.getName(), requestFile)

    //val signUpResponse=SignUpResponse(name,phoneNumber,placeOfBirth,dateOfBirth,timeOfBirth,email,gender,fileBody)
    val call =  apiService.signUp(map, multipartImage!!)
    call.enqueue(object : Callback<SignUpResponse> {
      override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
        if (response.isSuccessful) {
          binding.progressBar.visibility= View.GONE
          val responseBody = response.body()
          if (responseBody != null) {
            Toast.makeText(this@SignUoOneActivity, "Registration successful,Please Login!!", Toast.LENGTH_SHORT).show()
            //Log.d("response_message",responseBody.)
            Log.d("response_data",responseBody.toString())
            val destIntent = LoginActivity.getIntent(this@SignUoOneActivity, null)
            startActivity(destIntent)
            finishAffinity()
          } else {
            Toast.makeText(this@SignUoOneActivity, "Registration failed!! Mobile Number Already Registered", Toast.LENGTH_SHORT).show()
            Log.d(responseBody,"This fails in signup response")
            binding.progressBar.visibility= View.GONE
          }
        }
        else {
          Toast.makeText(this@SignUoOneActivity, "Registration Failed Mobile Number Already Registered", Toast.LENGTH_SHORT).show()
          Log.d(response.message(),"This fails in registration response")
          binding.progressBar.visibility= View.GONE
        }
      }
      override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
        Toast.makeText(this@SignUoOneActivity, "Registration failed: ${t.message}", Toast.LENGTH_SHORT).show()
        Log.d(t.message,"This fails in signup response")
        binding.progressBar.visibility= View.GONE
      }
    })
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == RESULT_OK && requestCode == pickImage) {

      imageUri = data?.data!!
      profileImageView.setImageURI(imageUri)
      val selectedFileURI: Uri = imageUri as Uri
      file = getFile(this, imageUri!!)
      //file = File(selectedFileURI.path.toString())
      Log.d("", "File : " + file.name)
      //uploadedFileName = file.toString()
      println("upload file name ${file.absoluteFile}")

      Log.d("my location","$file")

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
    val returnCursor = context.contentResolver.query(uri, null, null, null, null)!!
    val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
    returnCursor.moveToFirst()
    val name = returnCursor.getString(nameIndex)
    returnCursor.close()
    return name
  }

  fun getPath(uri: Uri?): String? {
    val projection = arrayOf(MediaStore.Images.Media.DATA)
    val cursor = contentResolver.query(uri!!, projection, null, null, null) ?: return null
    val column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
    cursor.moveToFirst()
    val s = cursor.getString(column_index)
    cursor.close()
    return s
  }
  // Extensions.kt
  fun createPartFromString(stringData: String): RequestBody {
    return stringData.toRequestBody("text/plain".toMediaTypeOrNull())
  }
  companion object {
    const val TAG: String = "SIGN_UO_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
