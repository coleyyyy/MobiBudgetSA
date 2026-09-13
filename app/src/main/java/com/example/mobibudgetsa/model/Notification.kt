package com.example.mobibudgetsa.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notifications")
data class Notification(
    @PrimaryKey
    val notificationId: Int,
    val message: String
)