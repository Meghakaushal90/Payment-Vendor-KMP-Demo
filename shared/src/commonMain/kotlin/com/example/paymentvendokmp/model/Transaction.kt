package com.example.paymentvendokmp.model

data class Transaction(
    val id: String,
    val orderId: String,
    val vendorId: String,
    val beneficiaryId: String,
    val amount: Double,
    val status: PaymentStatus = PaymentStatus.PENDING
)