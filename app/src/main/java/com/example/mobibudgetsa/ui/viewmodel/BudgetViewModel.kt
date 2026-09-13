package com.example.mobibudgetsa.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobibudgetsa.model.Budget
import com.example.mobibudgetsa.repository.BudgetRepository
import kotlinx.coroutines.launch

class BudgetViewModel(
    private val repository: BudgetRepository
) : ViewModel() {

    fun addBudget(budget: Budget) {
        viewModelScope.launch {
            repository.addBudget(budget)
        }
    }

    fun updateBudget(budget: Budget) {
        viewModelScope.launch {
            repository.updateBudget(budget)
        }
    }

    fun deleteBudget(budget: Budget) {
        viewModelScope.launch {
            repository.deleteBudget(budget)
        }
    }
}