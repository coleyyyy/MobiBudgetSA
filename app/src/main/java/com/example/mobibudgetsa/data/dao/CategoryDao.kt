package com.example.mobibudgetsa.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mobibudgetsa.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<Category>

    @Insert
    suspend fun insertCategory(category: Category)
}