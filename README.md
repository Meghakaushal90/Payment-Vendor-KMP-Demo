# Payment Vendor KMP Demo

A Kotlin Multiplatform (KMP) demo application based on **Payment Gateway** and **Multi-Vendor Beneficiary Management**.

This project demonstrates shared business logic for Android and iOS using Kotlin Multiplatform.

## Features

- Payment processing demo
- Payment validation
- Transaction status management
- Multi-vendor management concept
- Beneficiary management
- Activate / deactivate beneficiary
- Transaction history
- Shared Kotlin business logic
- Android and iOS project targets

## Tech Stack

- Kotlin
- Kotlin Multiplatform (KMP)
- Compose Multiplatform
- Android
- iOS
- Gradle

## Project Structure

```text
Payment-Vendor-KMP-Demo
│
├── androidApp
├── iosApp
├── shared
│   └── src
│       ├── commonMain
│       │   └── kotlin
│       │       └── com.example.paymentvendorkmp
│       │           ├── beneficiary
│       │           ├── model
│       │           └── payment
│       │
│       └── iosMain
│
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
KMP Architecture
The project keeps reusable business logic inside the shared module.
commonMain
Contains shared:
Payment models
Vendor models
Beneficiary models
Transaction models
Payment validation
Payment processing logic
Beneficiary management logic
Platform Specific
Android and iOS targets can use the shared business logic while keeping platform-specific implementation where required.
Payment Flow
Payment Request
      ↓
Validate Payment
      ↓
Process Payment
      ↓
Transaction Created
      ↓
SUCCESS / FAILED
Beneficiary Flow
Vendor
   ↓
Beneficiary
   ↓
Validate Details
   ↓
Add Beneficiary
   ↓
Activate / Deactivate
Demo Note
This project uses a mock payment flow for demonstration purposes.
No real payment gateway credentials, real bank credentials, or real financial transactions are used.
For a production application, the payment gateway and beneficiary operations would be integrated with the required secure backend APIs and payment provider.
Running the Project
Android
Open the project in Android Studio and run the Android application on an emulator or physical Android device.
iOS
Open the iosApp directory in Xcode on macOS to build and run the iOS application.
Purpose
The purpose of this demo is to demonstrate understanding of:
Kotlin Multiplatform architecture
Shared business logic
Payment domain concepts
Multi-vendor workflows
Beneficiary management
Transaction handling
Android and iOS project structure
