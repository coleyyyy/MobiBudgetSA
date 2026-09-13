package com.example.mobibudgetsa.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobibudgetsa.data.dao.BudgetDao
import com.example.mobibudgetsa.data.dao.CategoryDao
import com.example.mobibudgetsa.data.dao.NotificationDao
import com.example.mobibudgetsa.data.dao.TransactionDao
import com.example.mobibudgetsa.data.dao.UserDao
import com.example.mobibudgetsa.model.Budget
import com.example.mobibudgetsa.model.Category
import com.example.mobibudgetsa.model.Notification
import com.example.mobibudgetsa.model.Transaction
import com.example.mobibudgetsa.model.User

@Database(
    entities = [
        User::class,
        Category::class,
        Transaction::class,
        Budget::class,
        Notification::class
    ],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun categoryDao(): CategoryDao

    abstract fun transactionDao(): TransactionDao

    abstract fun budgetDao(): BudgetDao

    abstract fun notificationDao(): NotificationDao
}