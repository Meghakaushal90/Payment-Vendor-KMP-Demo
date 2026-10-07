package com.example.paymentvendokmp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class DemoBeneficiary(
    val id: String,
    val name: String,
    val accountNumber: String,
    val ifsc: String,
    val vendorId: String,
    val isActive: Boolean = true
)

data class DemoTransaction(
    val id: String,
    val orderId: String,
    val vendorId: String,
    val beneficiaryId: String,
    val amount: Double,
    val status: String
)

@Composable
fun App() {

    var selectedTab by remember { mutableStateOf(0) }

    var beneficiaries by remember {
        mutableStateOf(
            listOf(
                DemoBeneficiary(
                    id = "BEN001",
                    name = "Rahul Sharma",
                    accountNumber = "XXXXXX4589",
                    ifsc = "SBIN0001234",
                    vendorId = "VENDOR001"
                ),
                DemoBeneficiary(
                    id = "BEN002",
                    name = "Priya Enterprises",
                    accountNumber = "XXXXXX7821",
                    ifsc = "HDFC0004567",
                    vendorId = "VENDOR002"
                )
            )
        )
    }

    var transactions by remember {
        mutableStateOf(emptyList<DemoTransaction>())
    }

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                text = "Payment Vendor KMP",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = { selectedTab = 0 }
                ) {
                    Text("Payment")
                }

                Button(
                    onClick = { selectedTab = 1 }
                ) {
                    Text("Beneficiaries")
                }

                Button(
                    onClick = { selectedTab = 2 }
                ) {
                    Text("Transactions")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            when (selectedTab) {

                0 -> {

                    PaymentDemo(
                        onTransactionCreated = { transaction ->

                            transactions =
                                transactions + transaction
                        }
                    )
                }

                1 -> {

                    BeneficiaryDemo(
                        beneficiaries = beneficiaries,
                        onBeneficiaryChange = {
                            beneficiaries = it
                        }
                    )
                }

                2 -> {

                    TransactionHistory(
                        transactions = transactions
                    )
                }
            }
        }
    }
}


@Composable
fun PaymentDemo(
    onTransactionCreated: (DemoTransaction) -> Unit
) {

    var transactionCreated by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Payment Gateway Demo",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                transactionCreated = true

                onTransactionCreated(
                    DemoTransaction(
                        id = "TXN-ORDER001",
                        orderId = "ORDER001",
                        vendorId = "VENDOR001",
                        beneficiaryId = "BEN001",
                        amount = 1500.0,
                        status = "SUCCESS"
                    )
                )
            }
        ) {

            Text("Process Payment")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (transactionCreated) {

            Text("Transaction: TXN-ORDER001")
            Text("Amount: ₹1500")
            Text("Vendor: VENDOR001")
            Text("Beneficiary: BEN001")
            Text("Status: SUCCESS")

        } else {

            Text("No transaction yet")
        }
    }
}


@Composable
fun BeneficiaryDemo(
    beneficiaries: List<DemoBeneficiary>,
    onBeneficiaryChange: (List<DemoBeneficiary>) -> Unit
) {

    Column {

        Text(
            text = "Beneficiary Management",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn {

            items(beneficiaries) { beneficiary ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = beneficiary.name,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text("Beneficiary ID: ${beneficiary.id}")
                        Text("Vendor ID: ${beneficiary.vendorId}")
                        Text("Account: ${beneficiary.accountNumber}")
                        Text("IFSC: ${beneficiary.ifsc}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            if (beneficiary.isActive)
                                "Status: ACTIVE"
                            else
                                "Status: INACTIVE"
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {

                                onBeneficiaryChange(
                                    beneficiaries.map {

                                        if (it.id == beneficiary.id) {

                                            it.copy(
                                                isActive = !it.isActive
                                            )

                                        } else {
                                            it
                                        }
                                    }
                                )
                            }
                        ) {

                            Text(
                                if (beneficiary.isActive)
                                    "Deactivate"
                                else
                                    "Activate"
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun TransactionHistory(
    transactions: List<DemoTransaction>
) {

    Column {

        Text(
            text = "Transaction History",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(15.dp))

        if (transactions.isEmpty()) {

            Text("No transactions yet")

        } else {

            LazyColumn {

                items(transactions) { transaction ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = transaction.id,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text("Order ID: ${transaction.orderId}")
                            Text("Vendor: ${transaction.vendorId}")
                            Text("Beneficiary: ${transaction.beneficiaryId}")
                            Text("Amount: ₹${transaction.amount}")
                            Text("Status: ${transaction.status}")
                        }
                    }
                }
            }
        }
    }
}