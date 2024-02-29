package com.starmakers.app.service

import com.starmakers.app.responses.AboutUsModel
import com.starmakers.app.responses.ArtistRequestById
import com.starmakers.app.responses.ArtistRequests
import com.starmakers.app.responses.Audition
import com.starmakers.app.responses.AuditionPosition
import com.starmakers.app.responses.BannerResponses
import com.starmakers.app.responses.BookingResponseList
import com.starmakers.app.responses.CampaignDataById
import com.starmakers.app.responses.CampaignResponse
import com.starmakers.app.responses.CategoryItem
import com.starmakers.app.responses.ContactUs
import com.starmakers.app.responses.CrowdByIdResponses
import com.starmakers.app.responses.CrowdResponses
import com.starmakers.app.responses.EditingStudioData
import com.starmakers.app.responses.FAQItem
import com.starmakers.app.responses.FundingDemoVideos
import com.starmakers.app.responses.HouseLocationDataResponse
import com.starmakers.app.responses.LoginResponse
import com.starmakers.app.responses.LogoutResponse
import com.starmakers.app.responses.MusicStudioDataResponse
import com.starmakers.app.responses.MyStudioRequest
import com.starmakers.app.responses.PostReponses
import com.starmakers.app.responses.PrivacyPolicyModel
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.responses.ProfileResponseList
import com.starmakers.app.responses.RequestArtist
import com.starmakers.app.responses.RequestAudition
import com.starmakers.app.responses.RequestPostResponse
import com.starmakers.app.responses.SelectionDataResponse
import com.starmakers.app.responses.SelectionListResponse
import com.starmakers.app.responses.SignUpResponse
import com.starmakers.app.responses.StudioRequests
import com.starmakers.app.responses.MyAuditionRequest
import com.starmakers.app.responses.PaymentRequest
import com.starmakers.app.responses.PaymentRequestForDonate
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @FormUrlEncoded
    @POST("api/user-login/")
    fun getOtp(
        @Field("mobile_number")mobile: String
    ): Call<LoginResponse>


    @FormUrlEncoded
    @POST("api/verify-otp/")
    fun verifySignUpOtp(
        @Field("otp")otp: String
    ):Call<LoginResponse>


    @FormUrlEncoded
    @POST("api/user-genrate-otp/")
    fun getSignUpOTP(
        @Field("mobile_number")mobile: String
    ):Call<LoginResponse>


    @FormUrlEncoded
    @POST("api/otp-login-verify/")
    fun verifyLoginOtp(
        @Field("otp")otp:String
    ):Call<LoginResponse>

    @Multipart
    @POST("api/user-signup/")
    fun signUp(@PartMap() partMap: MutableMap<String, RequestBody>,
               @Part file: MultipartBody.Part)
            : Call<SignUpResponse>


    @GET("api/user-profile-details/")
    fun getProfile(
      @Header("Authorization") fetchAuthToken: String?
    ):Call<ProfileResponse>


    @GET("api/artistlist-create/")
    fun getArtistlist(
        @Header("Authorization") fetchAuthToken: String?,
        @Query("acting_field") actingField: String,
        @Query("category") category: String
    ):Call<ProfileResponseList>


    @GET("api/artistlist-update/{id}/")
    fun getArtistlistItem(
        @Header("Authorization") fetchAuthToken: String?,
        @Path("id") id: Int
    ):Call<BookingResponseList>


   @GET("api/faq/")
   fun getFAQList( @Header("Authorization") fetchAuthToken: String?): Call<MutableList<FAQItem>>


    @GET("api/faq-answer/{id}/")
    fun getFAQItem(
        @Header("Authorization") fetchAuthToken: String?,
        @Path("id") id: Int): Call<FAQItem>



    @GET("api/contact-help/")
    fun getContact(
        @Header("Authorization") fetchAuthToken: String?
    ):Call<MutableList<ContactUs>>


    @GET("api/privacy-policy/")
    fun getPrivacyPolicy(
        @Header("Authorization") fetchAuthToken: String?
    ):Call<ArrayList<PrivacyPolicyModel>>


    @GET("api/aboutus/")
    fun getAbout(
        @Header("Authorization") fetchAuthToken: String?
    ):Call<MutableList<AboutUsModel>>


    @GET("api/audition-create/")
    fun getAudition(
        @Header("Authorization")fetchAuthToken: String?
    ):Call<Audition>


    @GET("api/request-audition/")
    fun requestAudition(
        @Header("Authorization")fetchAuthToken: String?
    ):Call<RequestAudition>


    @GET("api/get-audition-list/{id}")
    fun requestPosition(
        @Header("Authorization")fetchAuthToken: String?,
        @Path("id") id: Int
    ):Call<MutableList<AuditionPosition>>



    @GET("api/get-selection-list/")
    fun get_selection_list(
        @Header("Authorization")fetchAuthToken: String?,
    ):Call<SelectionDataResponse>


    @GET("api/get-selection-list-by-ID/{id}")
    fun get_selection_list_by_id(
        @Header("Authorization")fetchAuthToken: String?,
        @Path("id") id: Int
    ):Call<SelectionListResponse>


    @Multipart
    @POST("api/request-audition/")
    fun PostResponses(
        @Header("Authorization")fetchAuthToken: String?,
                      @Part("audition") audition: Int,
                      @Part("position_id")position_id:Int,
                      @Part file: MultipartBody.Part,
                      @Part file1: MultipartBody.Part,
                      @Part file2: MultipartBody.Part,
                      @Part file3: MultipartBody.Part,
                      @Part file4: MultipartBody.Part,
                      @Part file5:MultipartBody.Part,
                      @Part file6: MultipartBody.Part)
            :Call<PostReponses>



    @Multipart
    @POST("api/artist/membership/")
    fun PostMembershipResponses(
        @Header("Authorization")fetchAuthToken: String?,
        @PartMap() partMap: MutableMap<String,RequestBody>,
//        @Part("artist_name")artistName:String,
//        @Part("mobile_number")mobile_number:String,
//        @Part("location")location:String,
//        @Part("age")age:String,
//        @Part("height")height:String,
//        @Part("weight")weight:String,
//        @Part("choose_acting_field")actingField:String,
//        @Part("total_no_of_movies")movies:String,
//        @Part("total_experience")exp:String,
//        @Part("select_category")category:String,
        @Part images: List<MultipartBody.Part>
    ):Call<ProfileResponse>


    @GET("api/studio-request-booking/")
    fun getStudioRequest(@Header("Authorization")fetchAuthToken: String?,
                         @Query("select_studio_type")sudioType:String):Call<EditingStudioData>

    @GET("api/studio-request-booking/")
    fun getMusicStudioRequest(@Header("Authorization")fetchAuthToken: String?,
                         @Query("select_studio_type")sudioType:String):Call<MusicStudioDataResponse>


    @GET("api/studio-request-booking/")
    fun getHouseStudioRequest(@Header("Authorization")fetchAuthToken: String?,
                              @Query("select_studio_type")sudioType:String):Call<HouseLocationDataResponse>


    @POST("api/studio-request-booking/")
    fun postRequestStudio(
        @Header("Authorization")fetchAuthToken: String?,
       @Body requestPostList: RequestPostResponse
    ):Call<ResponseBody>


    @POST("api/send-artist-booking-request/")
    fun postArtistRequest(
        @Header("Authorization")fetchAuthToken: String?,
        @Body requestArtist: RequestArtist
    ):Call<ResponseBody>
    @Multipart
    @PATCH("api/update-user-profile/")
    fun profileUpdate(
        @Header("Authorization")fetchAuthToken: String?,
        @PartMap() partMap: MutableMap<String,RequestBody>,
        @Part file: MultipartBody.Part,
    ):Call<ProfileResponse>



    @GET("api/user-artist-request/")
    fun getUserRequest(
        @Header("Authorization")fetchAuthToken: String?,
    ):Call<MutableList<ArtistRequests>>



    @GET("api/user-studio-request/")
    fun getStudioRequest(
        @Header("Authorization")fetchAuthToken: String?,
    ):Call<MutableList<StudioRequests>>

    @GET("api/user-artist-request-by-ID/{id}")
    fun get_user_list_by_id(
        @Header("Authorization")fetchAuthToken: String?,
        @Path("id") id: Int
    ):Call<ArtistRequestById>






    @GET("api/user-audition-request/")
    fun getMyAuditionRequest(
        @Header("Authorization")fetchAuthToken: String?,
    ):Call<MutableList<MyAuditionRequest>>


    @GET("api/get-category-list/")
    fun getCategory(
        @Header("Authorization")fetchAuthToken: String?,
    ):Call<MutableList<CategoryItem>>


    @GET("api/mobile-studio-update-delete/{id}/")
    fun getMyStudioRequest(
        @Header("Authorization")fetchAuthToken: String?,
        @Path("id") id: Int
    ):Call<MyStudioRequest>


    @GET("api/campaign-list-view/")
    fun getcampaign( @Header("Authorization")fetchAuthToken: String?):Call<CampaignResponse>


    @GET("api/campaign-list-view-by-id/{id}/")
    fun getCampaignById(@Header("Authorization")fetchAuthToken: String?,
                        @Path("id") id: Int):Call<CampaignDataById>
    @POST("api/logout/")
    fun logout(@Header("Authorization")fetchAuthToken: String?):Call<LogoutResponse>


    @POST("api/payment/initiate/")
    fun initiatePayment(@Body paymentRequest: PaymentRequest):Call<ResponseBody>


    @GET("api/home/banner/")
    fun getBanners(@Header("Authorization")fetchAuthToken: String?):Call<List<BannerResponses>>

    @GET("api/funding/video/")
    fun getFundingVideos(@Header("Authorization")fetchAuthToken: String?):Call<List<FundingDemoVideos>>


    @GET("api/crowd/funding/")
    fun getCrowdFundingImages(@Header("Authorization")fetchAuthToken: String?):Call<List<CrowdResponses>>


    @GET("api/campaign/details/{id}/")
    fun getCrowdImageByid(
        @Header("Authorization")fetchAuthToken: String?,
        @Path("id")id:String
    ):Call<CrowdByIdResponses>

    @POST("api/campaign/payment/initiate/")
    fun getDonatePaymentInitiate(
        @Body paymentRequest: PaymentRequestForDonate
    ):Call<ResponseBody>
}