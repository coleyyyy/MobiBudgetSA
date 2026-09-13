package com.example.mobibudgetsa.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey
    val transactionId: Int,
    val userId: Int,
    val amount: Double,
    val type: String,
    val categoryId: Int,
    val transactionDate: String,
    val description: String,
    val synced: Boolean
)