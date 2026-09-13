package com.example.mobibudgetsa.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val userId: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val language: String
)