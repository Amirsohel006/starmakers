package com.starmakers.app.service

import com.starmakers.app.responses.BookingResponse
import com.starmakers.app.responses.LoginResponse
import com.starmakers.app.responses.ProfileData
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.responses.ProfileResponseList
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
    ):Call<ProfileData>
}