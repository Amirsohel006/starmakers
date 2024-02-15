package com.starmakers.app.modules.artistmembership.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.modules.artistbookongfour.ui.ArtistBookongFourActivity
import com.starmakers.app.modules.artistmembership.`data`.model.SpinnerComponentOneModel
import com.starmakers.app.modules.artistmembership.`data`.model.SpinnerComponentSevenModel
import com.starmakers.app.modules.artistmembership.`data`.viewmodel.ArtistMembershipVM
import com.starmakers.app.modules.regstrationdetails.ui.RegstrationDetailsActivity
import com.starmakers.app.responses.ProfileResponse
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

class ArtistMembershipActivity :
    BaseActivity<com.starmakers.app.databinding.ActivityArtistMembershipBinding>(R.layout.activity_artist_membership) {
  private val viewModel: ArtistMembershipVM by viewModels<ArtistMembershipVM>()


  private val pickDocument = 100
  private val pickDocument1 =101
  private val pickDocument2=102
  private val pickDocument3=103
  private val pickDocument4=104

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

  private lateinit var sessionManager: SessionManager


  private var multipartImage: MultipartBody.Part? = null
  private var multipartImage1: MultipartBody.Part? = null
  private var multipartImage2: MultipartBody.Part? = null
  private var multipartImage3: MultipartBody.Part? = null
  private var multipartImage4: MultipartBody.Part? = null





  var artistName:String=""
  var mobileNumber:String=""
  val location:String=""
  var age:String=""
  var height:String=""
  var weight:String=""
  var chooseActingFiled:String=""
  val totalNuberofMovies:String=""
  val totalExperience:String=""
  var selectCategory:String=""



  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")

    sessionManager=SessionManager(this)


    viewModel.spinnerComponentSevenList.value = mutableListOf(
    SpinnerComponentSevenModel("Choose Acting Field"),
    SpinnerComponentSevenModel("Movies"),
    SpinnerComponentSevenModel("Serials")
    )


    val spinnerComponentSevenAdapter =
    SpinnerComponentSevenAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentSevenList.value?:
    mutableListOf())
    binding.spinnerComponentSeven.adapter = spinnerComponentSevenAdapter
    viewModel.spinnerComponentOneList.value = mutableListOf(
      SpinnerComponentOneModel("Select Category"),
    SpinnerComponentOneModel("Actor"),
    SpinnerComponentOneModel("Actress"),
    SpinnerComponentOneModel("Director"),
    SpinnerComponentOneModel("Assistant Director"),
      SpinnerComponentOneModel("Associate Director"),
      SpinnerComponentOneModel("Cameraman"),
      SpinnerComponentOneModel("Story Writer"),
      SpinnerComponentOneModel("Dialogue Writer"),
      SpinnerComponentOneModel("Singer"),
      SpinnerComponentOneModel("Supporting Singer"),
      SpinnerComponentOneModel("Fight Master"),
      SpinnerComponentOneModel("Dance Master"),
      SpinnerComponentOneModel("Dancer"),
      SpinnerComponentOneModel("Fighter"),
      SpinnerComponentOneModel("Still Photographer"),
      SpinnerComponentOneModel("Makeup Man"),
      SpinnerComponentOneModel("Hair Stylist"),
      SpinnerComponentOneModel("Costume Designer"),
      SpinnerComponentOneModel("Dubbing Artist"),
      SpinnerComponentOneModel("Artist Personal Assistant"),
      SpinnerComponentOneModel("Artist Personal Body Guard"),
      SpinnerComponentOneModel("Artist Personal Manager"),
      SpinnerComponentOneModel("Production Manager"),
      SpinnerComponentOneModel("Spot Boy"),
      SpinnerComponentOneModel("Set Artist/Worker")
    )


    val spinnerComponentOneAdapter =
    SpinnerComponentOneAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentOneList.value?:
    mutableListOf())
    binding.spinnerComponentOne.adapter = spinnerComponentOneAdapter
    binding.artistMembershipVM = viewModel


    binding.spinnerComponentSeven.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedModel = viewModel.spinnerComponentSevenList.value?.get(position)
        selectedModel?.let {
          chooseActingFiled = selectedModel.itemName
        }
      }

      override fun onNothingSelected(parent: AdapterView<*>?) {
        // Handle nothing selected if needed
      }
    }

    binding.spinnerComponentOne.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedModel = viewModel.spinnerComponentOneList.value?.get(position)
        selectedModel?.let {
          selectCategory = selectedModel.itemName
        }
      }

      override fun onNothingSelected(parent: AdapterView<*>?) {
        // Handle nothing selected if needed
      }
    }



    profileDocument=binding.imagePlus
    profileDocument1=binding.imagePlusOne
    profileDocument2=binding.imagePlusTwo
    profileDocument3=binding.imagePlusThree
    profileDocument4=binding.imagePlusFour


    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {

    binding.btnContinue.setOnClickListener {
      artistName=binding.etGroup149.text.toString()
      mobileNumber=binding.etGroup153.text.toString()
      age=binding.etGroup150.text.toString()
      height=binding.etGroup151.text.toString()
      weight=binding.etGroup152.text.toString()


      binding.progressBar.visibility=View.VISIBLE
      signUp()
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
//    binding.imageRectangle110Five.setOnClickListener {
//      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
//    binding.imageRectangle110Four.setOnClickListener {
//      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
//    binding.imageRectangle110Three.setOnClickListener {
//      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
//    binding.imageRectangle110Two.setOnClickListener {
//      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
//    binding.imageRectangle110One.setOnClickListener {
//      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
//    binding.btnContinue.setOnClickListener {
//      val destIntent = RegstrationDetailsActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.imageArrowleft.setOnClickListener {
      finish()
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



  private  fun signUp(
  ) {

    // Create a list to hold MultipartBody.Part objects for images
    val imageParts: MutableList<MultipartBody.Part> = mutableListOf()

    // Add each image file as a MultipartBody.Part object to the list
    fileProfilePic?.let { file ->
      val requestFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), file)
      val imagePart: MultipartBody.Part = MultipartBody.Part.createFormData("images", file.name, requestFile)
      imageParts.add(imagePart)
    }
    fileProfilePic1?.let { file ->
      val requestFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), file)
      val imagePart: MultipartBody.Part = MultipartBody.Part.createFormData("images", file.name, requestFile)
      imageParts.add(imagePart)
    }
    fileProfilePic2?.let { file ->
      val requestFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), file)
      val imagePart: MultipartBody.Part = MultipartBody.Part.createFormData("images", file.name, requestFile)
      imageParts.add(imagePart)
    }
    fileProfilePic3?.let { file ->
      val requestFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), file)
      val imagePart: MultipartBody.Part = MultipartBody.Part.createFormData("images", file.name, requestFile)
      imageParts.add(imagePart)
    }
    fileProfilePic4?.let { file ->
      val requestFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), file)
      val imagePart: MultipartBody.Part = MultipartBody.Part.createFormData("images", file.name, requestFile)
      imageParts.add(imagePart)
    }



    val map: MutableMap<String, RequestBody> = mutableMapOf()
    val artistName = createPartFromString(artistName)
    val phoneNumber = createPartFromString(mobileNumber)
    val location=createPartFromString(location)
    val age = createPartFromString(age)
    val height = createPartFromString(height)
    val weight = createPartFromString(weight)
    val acting_field=createPartFromString(chooseActingFiled)
    val totalnumberofmovues=createPartFromString(totalNuberofMovies)
    val experience=createPartFromString(totalExperience)
    val selectCategory=createPartFromString(selectCategory)

    map.put("artist_name", artistName)
    map.put("mobile_number", phoneNumber)
    map.put("location", location)
    map.put("age", age)
    map.put("height", height)
    map.put("weight", weight)
    map.put("choose_acting_field",acting_field)
    map.put("total_no_of_movies",totalnumberofmovues)
    map.put("total_experience",experience)
    map.put("select_category",selectCategory)





    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.PostMembershipResponses(authorization,map,imageParts)

    //val signUpResponse=SignUpResponse(name,phoneNumber,placeOfBirth,dateOfBirth,timeOfBirth,email,gender,fileBody)
    call.enqueue(object : Callback<ProfileResponse> {
      override fun onResponse(call: Call<ProfileResponse>, response: Response<ProfileResponse>) {
        if (response.isSuccessful) {
          binding.progressBar.visibility=View.GONE
          val responseBody = response.body()

          if(response.code()==201 || response.code()==200 ) {
            val destIntent =
              RegstrationDetailsActivity.getIntent(this@ArtistMembershipActivity, null)
            startActivity(destIntent)
            finishAffinity()
          }
          if (responseBody != null) {
            Toast.makeText(this@ArtistMembershipActivity, "Uploaded Successfull", Toast.LENGTH_SHORT).show()
            //Log.d("response_message",responseBody.)
            Log.d("response_data",responseBody.toString())


          } else {
            Toast.makeText(this@ArtistMembershipActivity, "Uploaded failed", Toast.LENGTH_SHORT).show()
            Log.d(responseBody,"This fails in signup response")
            binding.progressBar.visibility=View.GONE
          }
        }
        else {
          Toast.makeText(this@ArtistMembershipActivity, "Uploaded failed", Toast.LENGTH_SHORT).show()
          Log.d(response.message(),"This fails in registration response")
          binding.progressBar.visibility=View.GONE
        }
      }
      override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
        Toast.makeText(this@ArtistMembershipActivity, "Uploaded failed: ${t.message}", Toast.LENGTH_SHORT).show()
        Log.d(t.message,"This fails in signup response")
        binding.progressBar.visibility=View.GONE
      }
    })
  }



  fun createPartFromString(stringData: String): RequestBody {
    return stringData.toRequestBody("text/plain".toMediaTypeOrNull())
  }
  companion object {
    const val TAG: String = "ARTIST_MEMBERSHIP_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistMembershipActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
