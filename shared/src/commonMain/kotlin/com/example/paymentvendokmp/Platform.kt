package com.example.paymentvendokmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform