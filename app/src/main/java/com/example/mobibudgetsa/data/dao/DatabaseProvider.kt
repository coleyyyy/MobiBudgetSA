package com.example.mobibudgetsa.data

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    @Volatile
    private var INSTANCE: LocalDatabase? = null

    fun getDatabase(context: Context): LocalDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                LocalDatabase::class.java,
                "mobibudget_database"
            ).build()

            INSTANCE = instance
            instance
        }
    }
}