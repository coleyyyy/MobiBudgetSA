package com.example.mobibudgetsa.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mobibudgetsa.model.Budget

@Dao
interface BudgetDao {

    @Query("SELECT * FROM budgets")
    suspend fun getAllBudgets(): List<Budget>

    @Insert
    suspend fun insertBudget(budget: Budget)

    @Update
    suspend fun updateBudget(budget: Budget)

    @Delete
    suspend fun deleteBudget(budget: Budget)

    @Query("SELECT * FROM budgets WHERE userId = :userId")
    suspend fun getBudgetsForUser(userId: Int): List<Budget>
}