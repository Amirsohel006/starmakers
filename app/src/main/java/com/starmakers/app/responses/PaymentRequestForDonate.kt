package com.starmakers.app.responses

data class PaymentRequestForDonate (
    val user_id: String,
    val amount: String,
    val campaign_id:String
)