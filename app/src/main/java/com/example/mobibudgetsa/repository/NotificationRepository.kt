package com.example.mobibudgetsa.repository

import com.example.mobibudgetsa.data.dao.NotificationDao
import com.example.mobibudgetsa.model.Notification

class NotificationRepository(
    private val notificationDao: NotificationDao
) {

    suspend fun getNotifications(): List<Notification> {
        return notificationDao.getAllNotifications()
    }

    suspend fun addNotification(notification: Notification) {
        notificationDao.insertNotification(notification)
    }
}