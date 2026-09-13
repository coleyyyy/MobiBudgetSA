package com.example.mobibudgetsa.repository

import com.example.mobibudgetsa.data.dao.UserDao
import com.example.mobibudgetsa.model.User

class UserRepository(
    private val userDao: UserDao
) {

    suspend fun getUser(): User? {
        return userDao.getUser()
    }

    suspend fun saveUser(user: User) {
        userDao.insertUser(user)
    }
}