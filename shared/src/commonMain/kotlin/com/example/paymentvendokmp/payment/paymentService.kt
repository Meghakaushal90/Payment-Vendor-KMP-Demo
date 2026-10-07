package com.example.paymentvendokmp.payment

import com.example.paymentvendokmp.model.PaymentRequest
import com.example.paymentvendokmp.model.PaymentStatus
import com.example.paymentvendokmp.model.Transaction

class PaymentService {

    fun validatePayment(request: PaymentRequest): Boolean {
        return request.orderId.isNotBlank() &&
                request.vendorId.isNotBlank() &&
                request.beneficiaryId.isNotBlank() &&
                request.amount > 0
    }

    fun calculatePlatformFee(
        amount: Double,
        percentage: Double
    ): Double {
        return amount * percentage / 100
    }

    fun processPayment(
        request: PaymentRequest
    ): Transaction {

        val isValid = validatePayment(request)

        return Transaction(
            id = "TXN-${request.orderId}",
            orderId = request.orderId,
            vendorId = request.vendorId,
            beneficiaryId = request.beneficiaryId,
            amount = request.amount,
            status = if (isValid) {
                PaymentStatus.SUCCESS
            } else {
                PaymentStatus.FAILED
            }
        )
    }
}