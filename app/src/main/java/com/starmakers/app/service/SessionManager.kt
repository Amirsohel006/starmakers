package com.starmakers.app.service

import android.content.Context
import android.content.SharedPreferences
import com.starmakers.app.R

/**
 * Session manager to save and fetch data from SharedPreferences
 */
class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name),
        Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "access_token"
        const val REFRESH_TOKEN = "refresh_token"
        const val USER_ID="id"
        const val CITY_NAME="city_name"
        const val PIN_CODE="pin_code"
    }

    private val sharedPreferences =
        context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    /**
     * Function to save auth token
     */

    fun saveCityName(cityName:String){
        val editor=prefs.edit()
        editor.putString(CITY_NAME,cityName)
        editor.apply()
    }


    fun savePinCode(pincode:String){
        val editor=prefs.edit()
        editor.putString(PIN_CODE,pincode)
        editor.apply()
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }
    fun saveRefreshToken(token: String) {
        val editor = prefs.edit()
        editor.putString(REFRESH_TOKEN, token)
        editor.apply()
    }


    fun saveuserId(id:String){
        val userId=prefs.edit()
        userId.putString(USER_ID,id)
        userId.apply()
    }

    fun getUserId(): String? {
        return sharedPreferences.getString(USER_ID, null)
    }

    /**
     * Function to fetch auth token
     */

    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN,null)
    }

    fun fetchRefreshToken(): String? {
        return prefs.getString(REFRESH_TOKEN,null)
    }


    fun fetchCityName():String? {
        return prefs.getString(CITY_NAME,null)
    }


    fun fetchPinCode():String?{
        return prefs.getString(PIN_CODE,null)
    }

    fun logout() {
        prefs.edit().apply {
            remove(USER_TOKEN)
            remove(REFRESH_TOKEN)
            apply()
        }
    }


    fun clearSession() {
        sharedPreferences.edit().remove("access_token").apply()
    }
}