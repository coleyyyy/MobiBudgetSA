package com.example.mobibudgetsa.repository

import com.example.mobibudgetsa.data.dao.BudgetDao
import com.example.mobibudgetsa.model.Budget

class BudgetRepository(
    private val budgetDao: BudgetDao
) {

    suspend fun getBudgetsForUser(userId: Int): List<Budget> {
        return budgetDao.getBudgetsForUser(userId)
    }

    suspend fun addBudget(budget: Budget) {
        budgetDao.insertBudget(budget)
    }

    suspend fun updateBudget(budget: Budget) {
        budgetDao.updateBudget(budget)
    }

    suspend fun deleteBudget(budget: Budget) {
        budgetDao.deleteBudget(budget)
    }
}