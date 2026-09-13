package com.example.mobibudgetsa.repository

import com.example.mobibudgetsa.data.dao.CategoryDao
import com.example.mobibudgetsa.model.Category

class CategoryRepository(
    private val categoryDao: CategoryDao
) {

    suspend fun getCategories(): List<Category> {
        return categoryDao.getAllCategories()
    }

    suspend fun addCategory(category: Category) {
        categoryDao.insertCategory(category)
    }
}