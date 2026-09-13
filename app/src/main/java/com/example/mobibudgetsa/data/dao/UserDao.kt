package com.example.mobibudgetsa.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.example.mobibudgetsa.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getUser(): User?

    @Insert
    suspend fun insertUser(user: User)
}