package com.example.mobibudgetsa.ui.viewmodel

import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    fun calculateBalance(
        income: Double,
        expenses: Double
    ): Double {
        return income - expenses
    }
}