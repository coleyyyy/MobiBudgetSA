package com.example.mobibudgetsa.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mobibudgetsa.model.Notification

@Dao
interface NotificationDao {

    @Query("SELECT * FROM notifications")
    suspend fun getAllNotifications(): List<Notification>

    @Insert
    suspend fun insertNotification(notification: Notification)
}