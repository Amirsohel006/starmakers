package com.starmakers.app.modules.auditionsfour.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityAuditionsFourBinding
import com.starmakers.app.modules.artistbookongfour.ui.Listrectangle113Adapter
import com.starmakers.app.modules.artistmembership.data.model.SpinnerComponentOneModel
import com.starmakers.app.modules.auditions.ui.AuditionsAdapter
import com.starmakers.app.modules.auditionsfour.`data`.model.SpinnerComponentNineModel
import com.starmakers.app.modules.auditionsfour.`data`.viewmodel.AuditionsFourVM
import com.starmakers.app.modules.frametwentythree.ui.FrameTwentythreeActivity
import com.starmakers.app.responses.Audition
import com.starmakers.app.responses.AuditionPosition
import com.starmakers.app.responses.PostReponses
import com.starmakers.app.responses.RequestAudition
import com.starmakers.app.responses.RequestUserData
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.internal.canParseAsIpAddress
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import kotlin.String
import kotlin.Unit

class AuditionsFourActivity :
  BaseActivity<ActivityAuditionsFourBinding>(R.layout.activity_auditions_four) {
  private val viewModel: AuditionsFourVM by viewModels<AuditionsFourVM>()



  private val pickDocument = 100
  private val pickDocument1 =101
  private val pickDocument2=102
  private val pickDocument3=103
  private val pickDocument4=104
  private val pickVideo=105
  private val pickVideo1=106


  lateinit var profileDocument: ImageView
  lateinit var profileDocument1: ImageView
  lateinit var profileDocument2: ImageView
  lateinit var profileDocument3: ImageView
  lateinit var profileDocument4: ImageView

  private lateinit var profilePicUri: Uri
  private lateinit var profilePicUri1: Uri
  private lateinit var profilePicUri2: Uri
  private lateinit var profilePicUri3: Uri
  private lateinit var profilePicUri4: Uri

  private  var fileProfilePic: File?=null
  private  var fileProfilePic1: File?=null
  private  var fileProfilePic2: File?=null
  private  var fileProfilePic3: File?=null
  private  var fileProfilePic4: File?=null

  private  var fileVideo1:File?=null
  private  var fileVideo2:File?=null

  private lateinit var videoView: VideoView
  private lateinit var videoUri: Uri
  private lateinit var videoView1: VideoView
  private lateinit var videoUri1: Uri

  private lateinit var sessionManager: SessionManager


  private var multipartImage: MultipartBody.Part? = null
  private var multipartImage1: MultipartBody.Part? = null
  private var multipartImage2: MultipartBody.Part? = null
  private var multipartImage3: MultipartBody.Part? = null
  private var multipartImage4: MultipartBody.Part? = null

  private var multipartVideo: MultipartBody.Part? = null
  private var multipartVideo1: MultipartBody.Part? = null

  private var positionid: Int = -1 // Initialize with a default value
  private var auditionid:Int=-1


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    sessionManager=SessionManager(this)


    profileDocument=binding.imagePlus
    profileDocument1=binding.imagePlusOne
    profileDocument2=binding.imagePlusTwo
    profileDocument3=binding.imagePlusThree
    profileDocument4=binding.imagePlusFour

    videoView=binding.imagePlusFive
    videoView1=binding.imagePlusSix

    val profileDataId = intent.getIntExtra("artistDataId",-1)
    Log.d("Profile Data Id",profileDataId.toString())
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.requestPosition(authorization,profileDataId)

    call.enqueue(object : retrofit2.Callback<MutableList<AuditionPosition>>{
      override fun onResponse(
        call: Call<MutableList<AuditionPosition>>,
        response: Response<MutableList<AuditionPosition>>
      ) {
        val auditionPositions = response.body()
        if (auditionPositions != null) {
          val spinnerItems = auditionPositions.map {it.audition_positions}.toMutableList()



//          val positionid=auditionPositions[0].id
//          this@AuditionsFourActivity.positionid = positionid
          // Assuming you have a reference to your Spinner view
          val spinner = findViewById<Spinner>(R.id.spinnerComponentNine)

          // Create an ArrayAdapter to populate the Spinner
          val adapter = ArrayAdapter<String>(
            this@AuditionsFourActivity, // Replace with your actual activity reference
            R.layout.spinner_layout,
            spinnerItems
          )

          // Set the dropdown layout style
          adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

          // Set the adapter on the Spinner
          spinner.adapter = adapter

          // Optionally, set an item selected listener if needed
          spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
              parent: AdapterView<*>?,
              view: View?,
              position: Int,
              id: Long
            ) {
              // Check if a valid item is selected
              if (position >= 0 && position < auditionPositions.size) {
                // Handle item selection here if needed
                val selectedValue = auditionPositions[position].id
                this@AuditionsFourActivity.positionid = selectedValue
                this@AuditionsFourActivity.auditionid=auditionPositions[position].audition
                // Do something with the selected value
              } else {
                // Handle the case where the user clears the selection or selects an invalid item
                this@AuditionsFourActivity.positionid = 0 // or any other suitable value
              }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
              // Handle case when nothing is selected
            }
          }
        }
      }


      override fun onFailure(call: Call<MutableList<AuditionPosition>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })

    binding.auditionsFourVM = viewModel


    fetchData()

    binding.btnParticipate.setOnClickListener {
      val positionId = this@AuditionsFourActivity.positionid
      val auditionId = this@AuditionsFourActivity.auditionid

      postResponses(auditionId,positionId)
    }
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)

  }

  override fun setUpClicks(): Unit {
//    binding.btnParticipate.setOnClickListener {
//      val destIntent = FrameTwentythreeActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }

    binding.imagePlus.setOnClickListener {
      selectFile()
    }

    binding.imagePlusOne.setOnClickListener {
      selectFile1()
    }

    binding.imagePlusTwo.setOnClickListener {
      selectFile2()
    }

    binding.imagePlusThree.setOnClickListener {
      selectFile3()
    }

    binding.imagePlusFour.setOnClickListener {
      selectFile4()
    }

    binding.linearColumnplusFive.setOnClickListener{
      selectFile5()
    }

    binding.linearColumnplusSix.setOnClickListener{
      selectFile6()
    }


  }


  private fun selectFile() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*/*" // Allow all file types
    startActivityForResult(intent, pickDocument)
  }


  private fun selectFile1() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*/*" // Allow all file types
    startActivityForResult(intent, pickDocument1)
  }
  private fun selectFile2() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*/*" // Allow all file types
    startActivityForResult(intent, pickDocument2)
  }

  private fun selectFile3() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*/*" // Allow all file types
    startActivityForResult(intent, pickDocument3)
  }

  private fun selectFile4() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*/*" // Allow all file types
    startActivityForResult(intent, pickDocument4)
  }


  private fun selectFile5() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "video/*" // Specify the MIME type for videos
    startActivityForResult(intent, pickVideo)
  }

  private fun selectFile6() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "video/*" // Specify the MIME type for videos
    startActivityForResult(intent, pickVideo1)
  }

  private fun postResponses( audition: Int,positionId: Int){
    val requestFileDocument1: RequestBody? =
      fileProfilePic?.let { RequestBody.create("*/*".toMediaType(), it) }

    val requestFileDocument2: RequestBody? =
      fileProfilePic1?.let { RequestBody.create("*/*".toMediaType(), it) }

    val requestFileDocument3: RequestBody? =
      fileProfilePic2?.let { RequestBody.create("*/*".toMediaType(), it) }

    val requestFileDocument4: RequestBody? =
      fileProfilePic3?.let { RequestBody.create("*/*".toMediaType(), it) }

    val requestFileDocument5: RequestBody? =
      fileProfilePic4?.let { RequestBody.create("*/*".toMediaType(), it) }

    val requestFileDocument6: RequestBody? =
      fileVideo1?.let { RequestBody.create("*/*".toMediaType(), it) }

    val requestFileDocument7: RequestBody? =
      fileVideo2?.let { RequestBody.create("*/*".toMediaType(), it) }


    val progressBar = findViewById<ProgressBar>(R.id.progressBar)
    progressBar.visibility = View.VISIBLE

    multipartImage =
      requestFileDocument1?.let {
        MultipartBody.Part.createFormData("acting_picture_1", fileProfilePic?.name,
          it
        )
      }

    multipartImage1 =
      requestFileDocument2?.let {
        MultipartBody.Part.createFormData("acting_picture_2", fileProfilePic1?.name,
          it
        )
      }
    multipartImage2 =
      requestFileDocument3?.let {
        MultipartBody.Part.createFormData("acting_picture_3", fileProfilePic2?.name,
          it
        )
      }
    multipartImage3 =
      requestFileDocument4?.let {
        MultipartBody.Part.createFormData("acting_picture_4", fileProfilePic3?.name,
          it
        )
      }
    multipartImage4 =
      requestFileDocument5?.let {
        MultipartBody.Part.createFormData("acting_picture_5", fileProfilePic4?.name,
          it
        )
      }


    multipartVideo =
      requestFileDocument6?.let {
        MultipartBody.Part.createFormData("acting_video_1", fileVideo1?.name,
          it
        )
      }


    multipartVideo1 =
      requestFileDocument7?.let {
        MultipartBody.Part.createFormData("acting_video_2", fileVideo2?.name,
          it
        )
      }

    if(multipartImage==null  || multipartImage1==null  || multipartImage2==null || multipartImage3==null || multipartImage4==null ||
      multipartVideo==null || multipartVideo1==null){
      Toast.makeText(this,"Please Submit All Videos And Images For Verification!!",Toast.LENGTH_LONG).show()
      binding.progressBar.visibility=View.GONE
      return
    }


    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.PostResponses(authorization,audition,positionId,multipartImage!!,multipartImage1!!,multipartImage2!!,multipartImage3!!,multipartImage4!!,multipartVideo!!,multipartVideo1!!)

    call.enqueue(object : retrofit2.Callback<PostReponses>{
      override fun onResponse(
        call: Call<PostReponses>,
        response: Response<PostReponses>
      ) {
        progressBar.visibility = View.GONE
        val customerResponse=response.body()

        if(customerResponse!=null){

          val dialogBinding = layoutInflater.inflate(R.layout.activity_frame_twentythree, null)
          val myDialoge = Dialog(this@AuditionsFourActivity)
          myDialoge.setContentView(dialogBinding)

          val img=dialogBinding.findViewById<ImageView>(R.id.imageComponentlott)
          val img1=dialogBinding.findViewById<ImageView>(R.id.imageHttpslottief)


          Glide.with(this@AuditionsFourActivity).load(R.drawable.done).into(img)
          Glide.with(this@AuditionsFourActivity).load(R.drawable.celebration).into(img1)
          myDialoge.setCancelable(true)
          myDialoge.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
          myDialoge.show()

        }
      }

      override fun onFailure(call: Call<PostReponses>, t: Throwable) {
        progressBar.visibility = View.GONE
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
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

        if(customerResponse!=null){
          binding.etName.text=customerResponse.data.artist_name
          binding.etmobileNumber.text=customerResponse.data.mobile_number
          binding.etAge1.text= customerResponse.data.age.toString()
          binding.etHeight1.text=customerResponse.data.height
          binding.etWeight.text=customerResponse.data.weight

        }
      }

      override fun onFailure(call: Call<RequestAudition>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }




  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == RESULT_OK && requestCode == pickDocument) {

      profilePicUri = data?.data!!
      profileDocument.setImageURI(profilePicUri)
      val selectedFileURI: Uri =profilePicUri
      fileProfilePic = getFile(this, profilePicUri)
      //file = File(selectedFileURI.path.toString())
      Log.d("", "File : " + fileProfilePic!!.name)
      //uploadedFileName = file.toString()
      println("upload file name ${fileProfilePic!!.absoluteFile}")

      Log.d("my location","$fileProfilePic")
    }

    if (resultCode == RESULT_OK && requestCode == pickDocument1) {

      profilePicUri1 = data?.data!!
      profileDocument1.setImageURI(profilePicUri1)
      val selectedFileURI: Uri =profilePicUri1
      fileProfilePic1 = getFile(this, profilePicUri1)
      //file = File(selectedFileURI.path.toString())
      Log.d("", "File : " + fileProfilePic1!!.name)
      //uploadedFileName = file.toString()
      println("upload file name ${fileProfilePic1!!.absoluteFile}")

      Log.d("my location","$fileProfilePic1")
    }

    if (resultCode == RESULT_OK && requestCode == pickDocument2) {

      profilePicUri2 = data?.data!!
      profileDocument2.setImageURI(profilePicUri2)
      val selectedFileURI: Uri =profilePicUri2
      fileProfilePic2 = getFile(this, profilePicUri2)
      //file = File(selectedFileURI.path.toString())
      Log.d("", "File : " + fileProfilePic2!!.name)
      //uploadedFileName = file.toString()
      println("upload file name ${fileProfilePic2!!.absoluteFile}")

      Log.d("my location","$fileProfilePic2")
    }
    if (resultCode == RESULT_OK && requestCode == pickDocument3) {

      profilePicUri3= data?.data!!
      profileDocument3.setImageURI(profilePicUri3)
      val selectedFileURI: Uri =profilePicUri3
      fileProfilePic3 = getFile(this, profilePicUri3)
      //file = File(selectedFileURI.path.toString())
      Log.d("", "File : " + fileProfilePic3!!.name)
      //uploadedFileName = file.toString()
      println("upload file name ${fileProfilePic3!!.absoluteFile}")

      Log.d("my location","$fileProfilePic3")
    }

    if (resultCode == RESULT_OK && requestCode == pickDocument4) {

      profilePicUri4= data?.data!!
      profileDocument4.setImageURI(profilePicUri4)
      val selectedFileURI: Uri =profilePicUri4
      fileProfilePic4 = getFile(this, profilePicUri4)
      //file = File(selectedFileURI.path.toString())
      Log.d("", "File : " + fileProfilePic4!!.name)
      //uploadedFileName = file.toString()
      println("upload file name ${fileProfilePic4!!.absoluteFile}")

      Log.d("my location","$fileProfilePic4")
    }

    if (resultCode == RESULT_OK && requestCode == pickVideo) {
      videoUri = data?.data!!
      videoView.setVideoURI(videoUri)
      fileVideo1=getFile(this,videoUri)
      videoView.start()

      // Now you have the video URI, and you can use it to upload the video to the server.
      // You can also store the URI for later use in the same way you did for images.
    }

    if (resultCode == RESULT_OK && requestCode == pickVideo1) {
      videoUri1 = data?.data!!
      videoView1.setVideoURI(videoUri1)
      fileVideo2=getFile(this,videoUri1)
      videoView1.start()


      // Now you have the video URI, and you can use it to upload the video to the server.
      // You can also store the URI for later use in the same way you did for images.
    }
//    videoView1.stopPlayback()
//    videoView.stopPlayback()



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


  companion object {
    const val TAG: String = "AUDITIONS_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AuditionsFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}