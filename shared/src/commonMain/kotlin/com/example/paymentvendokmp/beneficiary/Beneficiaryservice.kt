package com.example.paymentvendokmp.beneficiary

import com.example.paymentvendokmp.model.Beneficiary

class BeneficiaryService {

    private val beneficiaries = mutableListOf<Beneficiary>()

    fun addBeneficiary(
        beneficiary: Beneficiary
    ): Boolean {

        if (beneficiary.name.isBlank()) {
            return false
        }

        if (beneficiary.accountNumber.isBlank()) {
            return false
        }

        if (beneficiary.ifsc.isBlank()) {
            return false
        }

        beneficiaries.add(beneficiary)

        return true
    }

    fun getBeneficiaries(
        vendorId: String
    ): List<Beneficiary> {

        return beneficiaries.filter {
            it.vendorId == vendorId && it.isActive
        }
    }

    fun deactivateBeneficiary(
        id: String
    ): Boolean {

        val index = beneficiaries.indexOfFirst {
            it.id == id
        }

        if (index == -1) {
            return false
        }

        val oldBeneficiary = beneficiaries[index]

        beneficiaries[index] =
            oldBeneficiary.copy(isActive = false)

        return true
    }
}