package com.starmakers.app.service

import com.starmakers.app.responses.AboutUsModel
import com.starmakers.app.responses.Audition
import com.starmakers.app.responses.AuditionPosition
import com.starmakers.app.responses.BookingResponseList
import com.starmakers.app.responses.ContactUs
import com.starmakers.app.responses.FAQItem
import com.starmakers.app.responses.LoginResponse
import com.starmakers.app.responses.LogoutResponse
import com.starmakers.app.responses.PostReponses
import com.starmakers.app.responses.PrivacyPolicyModel
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.responses.ProfileResponseList
import com.starmakers.app.responses.RequestAudition
import com.starmakers.app.responses.RequestUserData
import com.starmakers.app.responses.SelectionDataResponse
import com.starmakers.app.responses.SelectionListResponse
import com.starmakers.app.responses.SignUpResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
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

    @POST("api/logout/")
    fun logout(@Header("Authorization")fetchAuthToken: String?):Call<LogoutResponse>

}