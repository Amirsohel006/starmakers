package com.starmakers.app.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

class OtpBroadcastReceiver : BroadcastReceiver() {

    var otpBroadcastReceiverListener: OtpBroadcastListener? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION == intent?.action) {
            val extras = intent.extras
            val status = extras?.get(SmsRetriever.EXTRA_STATUS) as Status

            when (status.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    // Get the SMS message contents
                    val message = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE) as String
                    otpBroadcastReceiverListener?.onSuccess(message)
                }
                CommonStatusCodes.TIMEOUT -> {
                    otpBroadcastReceiverListener?.onFailure()
                }
            }
        }
    }

    interface OtpBroadcastListener {
        fun onSuccess(message: String)
        fun onFailure()
    }
}
