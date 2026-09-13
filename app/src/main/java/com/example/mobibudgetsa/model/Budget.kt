package com.example.mobibudgetsa.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budgets")
data class Budget(
    @PrimaryKey
    val budgetId: Int,
    val userId: Int,
    val categoryId: Int,
    val amount: Double,
    val month: Int,
    val year: Int
)