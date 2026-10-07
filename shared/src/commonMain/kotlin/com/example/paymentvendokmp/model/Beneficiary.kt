package com.example.paymentvendokmp.model

data class Beneficiary(
    val id: String,
    val vendorId: String,
    val name: String,
    val accountNumber: String,
    val ifsc: String,
    val isActive: Boolean = true
)