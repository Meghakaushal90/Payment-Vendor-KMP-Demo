package com.example.paymentvendokmp.model

data class Vendor(
    val id: String,
    val name: String,
    val email: String,
    val isActive: Boolean = true
)