package com.example.paymentvendokmp.model

data class PaymentRequest(
    val orderId: String,
    val vendorId: String,
    val beneficiaryId: String,
    val amount: Double,
    val currency: String = "INR"
)