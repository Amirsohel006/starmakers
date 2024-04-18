package com.starmakers.app.modules.home.ui
import SliderrectangleelevenAdapter
import VideoAdapter
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentHomeBinding
import com.starmakers.app.modules.artistbookongfive.ui.ArtistBookongFiveActivity
import com.starmakers.app.modules.artistbookongone.ui.ArtistBookongOneActivity
import com.starmakers.app.modules.artistmembership.ui.ArtistMembershipActivity
import com.starmakers.app.modules.auditions.ui.AuditionsActivity
import com.starmakers.app.modules.campaignone.ui.CampaignOneActivity
import com.starmakers.app.modules.frame311.ui.Frame311Activity
import com.starmakers.app.modules.home.`data`.viewmodel.HomeVM
import com.starmakers.app.modules.selectionlist.ui.SelectionListActivity
import com.starmakers.app.modules.studiobookong1.ui.StudioBookong1Activity
import com.starmakers.app.responses.BannerResponses
import com.starmakers.app.responses.CrowdResponses
import com.starmakers.app.responses.FundingDemoVideos
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit
import kotlin.collections.ArrayList

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.io.IOException

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {


  private lateinit var fusedLocationClient: FusedLocationProviderClient
  
  private lateinit var sessionManager: SessionManager


  private val imageSliderItems: ArrayList<CrowdResponses> = arrayListOf()



  private lateinit var autoScrollHandler: Handler
  private lateinit var autoScrollRunnable: Runnable

  private val CAMERA_PERMISSION_REQUEST_CODE = 101

  private val PERMISSION_REQUEST_CODE=102

  private val viewModel: HomeVM by viewModels<HomeVM>()


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

    return super.onCreateView(inflater, container, savedInstanceState)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
   // startAutoScroll()

    Handler().postDelayed({
      setupImageSlider()
    }, 1000) // Delay initialization by 1 second


  }

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    sessionManager=SessionManager(requireActivity())

//
//    requestLocationPermissions()
//
//    requestCameraPermission()


    requestPermissions()

    fetchData()


    getBanner()

    fundingVideos()


    getCrowdFundingZone()





    binding.homeVM = viewModel
  }




  private fun setupImageSlider() {
    val sliderAdapter = SliderrectangleelevenAdapter(imageSliderItems, true) { itemId ->
      val intent = Intent(requireActivity(), CampaignOneActivity::class.java)
      intent.putExtra("itemId", itemId) // Pass the id to the next activity
      startActivity(intent)
    }

    binding.imageSliderSliderrectangleeleven.adapter = sliderAdapter
    binding.imageSliderSliderrectangleeleven.onIndicatorProgress = { selectingPosition, progress ->
     binding.indicatorVolume.onPageScrolled(selectingPosition, progress)
    }
    binding.indicatorVolume.updateIndicatorCounts(binding.imageSliderSliderrectangleeleven.indicatorCount)
  }




  private fun requestPermissions() {
    val locationPermissionGranted = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    val cameraPermissionGranted = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

    val permissionsToRequest = ArrayList<String>()

    // Check if location permission is not granted
    if (!locationPermissionGranted) {
      permissionsToRequest.add(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    // Check if camera permission is not granted
    if (!cameraPermissionGranted) {
      permissionsToRequest.add(Manifest.permission.CAMERA)
    }

    // Request permissions if there are any to request
    if (permissionsToRequest.isNotEmpty()) {
      ActivityCompat.requestPermissions(
        requireActivity(),
        permissionsToRequest.toTypedArray(),
        PERMISSION_REQUEST_CODE
      )
    } else {
      // Both permissions are already granted, you can perform your tasks here
      getLocation()
      // Perform camera-related tasks here
    }
  }

//  private fun requestLocationPermissions() {
//    if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//      requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
//    } else {
//      getLocation()
//    }
//  }


//  private fun requestCameraPermission() {
//    if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
//      != PackageManager.PERMISSION_GRANTED
//    ) {
//      ActivityCompat.requestPermissions(
//        requireActivity(),
//        arrayOf(Manifest.permission.CAMERA),
//        CAMERA_PERMISSION_REQUEST_CODE
//      )
//    } else {
//      // Permission already granted
//      // You can perform your camera related tasks here
//      //Toast.makeText(requireActivity(),"Please Give Camera Access Permission",Toast.LENGTH_SHORT).show()
//    }
//  }


  private fun getLocation() {
    if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
      return
    }
    fusedLocationClient.lastLocation
      .addOnSuccessListener { location ->
        location?.let {
          val address = getAddressFromLocation(location.latitude, location.longitude)
          address?.let {
            val cityName = it.locality ?: ""
            val pinCode = it.postalCode ?: ""
            sessionManager.saveCityName(cityName)
            sessionManager.savePinCode(pinCode)
            binding.spinnerGroup1221.text = cityName
            binding.spinnerGroup1222.text = pinCode
            Log.d("City Name", cityName)
            Log.d("Pin Code", pinCode)
            // Now you can handle cityName and pinCode as needed
            // Update UI here after location data is fetched
            // For example:
            // binding.spinnerGroup1221.text = cityName
            // binding.spinnerGroup1222.text = pinCode
          }
        }
      }
      .addOnFailureListener { e ->
        Toast.makeText(requireContext(), "Error getting location: ${e.message}", Toast.LENGTH_SHORT).show()
      }
  }


  private fun getAddressFromLocation(latitude: Double, longitude: Double): Address? {
    val context = context ?: return null // Check if the fragment is attached to a context
    val geocoder = Geocoder(context)
    var address: Address? = null

    try {
      val addresses = geocoder.getFromLocation(latitude, longitude, 1)
      if (addresses!!.isNotEmpty()) {
        address = addresses[0]
       // Toast.makeText(requireActivity(), "Country Code: ${address.countryCode}", Toast.LENGTH_SHORT).show()
      }
    } catch (e: IOException) {
      e.printStackTrace()
    }

    return address
  }









  @Deprecated("Deprecated in Java")
  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    when (requestCode) {
      LOCATION_PERMISSION_REQUEST_CODE -> {
        if (permissions.contains(Manifest.permission.ACCESS_FINE_LOCATION) &&
          grantResults.isNotEmpty() && grantResults[permissions.indexOf(Manifest.permission.ACCESS_FINE_LOCATION)] == PackageManager.PERMISSION_GRANTED
        ) {
          getLocation()
          Toast.makeText(requireContext(), "Location permission Granted!!", Toast.LENGTH_SHORT).show()
        } else {
          // Handle the case where the user denies the location permission
          Toast.makeText(requireContext(), "Location permission denied", Toast.LENGTH_SHORT).show()
        }
      }
      CAMERA_PERMISSION_REQUEST_CODE -> {
        if (permissions.contains(Manifest.permission.CAMERA) &&
          grantResults.isNotEmpty() && grantResults[permissions.indexOf(Manifest.permission.CAMERA)] == PackageManager.PERMISSION_GRANTED
        ) {
          // Camera permission granted
          // You can perform your camera related tasks here
          Toast.makeText(requireContext(), "Camera permission Granted!!", Toast.LENGTH_SHORT).show()
        } else {
          // Camera permission denied
          Toast.makeText(requireContext(), "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
      }
      // Add more cases for other permissions if needed
    }
  }



  private fun startAutoScroll() {
    autoScrollHandler = Handler(Looper.getMainLooper())
    autoScrollRunnable = object : Runnable {
      override fun run() {
        val currentItem = binding.imageSliderSliderrectangleeleven.currentItem
        val nextItem = (currentItem + 1) % imageSliderItems.size
        binding.imageSliderSliderrectangleeleven.setCurrentItem(nextItem, true)
        autoScrollHandler.postDelayed(this, AUTO_SCROLL_DELAY_MS)
      }
    }
    autoScrollHandler.postDelayed(autoScrollRunnable, AUTO_SCROLL_DELAY_MS)
  }


  override fun onPause(): Unit {
    binding.imageSliderSliderrectangleeleven.pauseAutoScroll()
    super.onPause()
  }

  override fun onResume(): Unit {
    super.onResume()
    binding.imageSliderSliderrectangleeleven.resumeAutoScroll()
  }

  override fun setUpClicks(): Unit {

    binding.imageQuestion.setOnClickListener {
      val i=Intent(requireActivity(), SelectionListActivity::class.java)
      startActivity(i)
    }


    binding.imageMenu.setOnClickListener{
      val i =Intent(requireActivity(),Frame311Activity::class.java)
      startActivity(i)
    }


    binding.profilePicture.setOnClickListener {
      val i = Intent(requireActivity(),ArtistBookongOneActivity::class.java)
      startActivity(i)
    }
    binding.linearColumnuntitleddesign.setOnClickListener {
      val i=Intent(requireActivity(), ArtistMembershipActivity::class.java)
      startActivity(i)
    }

    binding.linearColumn.setOnClickListener {
      val i =Intent(requireActivity(), ArtistBookongFiveActivity::class.java)
      startActivity(i)
    }

    binding.linearColumnOne.setOnClickListener {
      val i=Intent(requireActivity(), AuditionsActivity::class.java)
      startActivity(i)
    }

    binding.linearColumnTwo.setOnClickListener {
      val i=Intent(requireActivity(), StudioBookong1Activity::class.java)
      startActivity(i)
    }

  }


  fun getCrowdFundingZone(){
    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"
    val call = serviceGenerator.getCrowdFundingImages(authorization)

    call.enqueue(object : retrofit2.Callback<List<CrowdResponses>> {
      override fun onResponse(
        call: Call<List<CrowdResponses>>,
        response: Response<List<CrowdResponses>>
      ) {
        val crowdFundingImages = response.body()
        Log.d("Server Response", crowdFundingImages.toString())

        crowdFundingImages?.let { list ->
          imageSliderItems.clear() // Clear previous data
          imageSliderItems.addAll(list) // Add new crowd funding images
          binding.imageSliderSliderrectangleeleven.adapter?.notifyDataSetChanged()
        }
      }

      override fun onFailure(call: Call<List<CrowdResponses>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }


  fun getBanner(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getBanners(authorization)

    call.enqueue(object : retrofit2.Callback<List<BannerResponses>>{
      override fun onResponse(
        call: Call<List<BannerResponses>>,
        response: Response<List<BannerResponses>>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){

          val image=customerResponse[0].image?:""
            val file = ApiManager.getImageUrl(image!!)
            Picasso.get().load(file).into(binding.imageRectangle153)
        }
      }

      override fun onFailure(call: Call<List<BannerResponses>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }


  fun fundingVideos() {
    if (!isAdded) {
      // Fragment is not attached to an activity
      return
    }

    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"
    val call = serviceGenerator.getFundingVideos(authorization)

    call.enqueue(object : retrofit2.Callback<List<FundingDemoVideos>> {
      override fun onResponse(
        call: Call<List<FundingDemoVideos>>,
        response: Response<List<FundingDemoVideos>>
      ) {
        if (!isAdded) {
          // Fragment is not attached to an activity
          return
        }

        val customerResponse = response.body()

        binding.mystudiostext.visibility = if (customerResponse.isNullOrEmpty()) View.VISIBLE else View.GONE
        binding.recyclerviewforfundingvideos.visibility = if (customerResponse.isNullOrEmpty()) View.GONE else View.VISIBLE

        if (!customerResponse.isNullOrEmpty()) {
          // Update the adapter with the list of videos
          binding.recyclerviewforfundingvideos.apply {
            layoutManager =
              LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            val audtioAdapter = VideoAdapter(requireActivity(), customerResponse)
            adapter = audtioAdapter
          }
        }
      }

      override fun onFailure(call: Call<List<FundingDemoVideos>>, t: Throwable) {
        if (!isAdded) {
          // Fragment is not attached to an activity
          return
        }

        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })

  }




  private fun fetchData(){
    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"
    val call = serviceGenerator.getProfile(authorization)

    call.enqueue(object : retrofit2.Callback<ProfileResponse>{
      override fun onResponse(
        call: Call<ProfileResponse>,
        response: Response<ProfileResponse>
      ) {
        val customerResponse = response.body()

        if(customerResponse != null) {
          binding.txtRahul.text = customerResponse.name
          sessionManager.saveuserId(customerResponse.id.toString())

          // Check if artistPictures is not null and not empty
          if (!customerResponse.artistPictures.isNullOrEmpty()) {
            // Load the first artist picture if available
            val profilePicture: ImageView = binding.profilePicture
            val image = customerResponse.artistPictures[0].artistPicture
            val file = ApiManager.getImageUrl(image!!)
            Picasso.get().load(file).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
          } else {
            // Check if profile picture is not empty
            val profilePicture: ImageView = binding.profilePicture
            val image = customerResponse.profile
            if (!image.isNullOrEmpty()) {
              val file = ApiManager.getImageUrl(image)
              Picasso.get().load(file).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
            } else {
              // Load a default picture if both artistPictures and profile are empty
              Picasso.get().load(R.drawable.default_profile_pic).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
            }
          }
        }
      }

      override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }



  companion object {
    const val TAG: String = "HOME_FRAGMENT"

    private const val LOCATION_PERMISSION_REQUEST_CODE = 1001

    private const val AUTO_SCROLL_DELAY_MS = 5000L
    private const val AUTO_SCROLL_HANDLER_DELAY_MS = 3000L

    fun getInstance(bundle: Bundle?): HomeFragment {
      val fragment = HomeFragment()
      fragment.arguments = bundle
      return fragment
    }
  }



}
