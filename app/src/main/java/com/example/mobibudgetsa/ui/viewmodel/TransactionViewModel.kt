package com.example.mobibudgetsa.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobibudgetsa.model.Transaction
import com.example.mobibudgetsa.repository.TransactionRepository
import kotlinx.coroutines.launch

class TransactionViewModel(
    private val repository: TransactionRepository
) : ViewModel() {



    fun addTransaction(transaction: Transaction) {
        viewModelScope.launch {
            repository.addTransaction(transaction)
        }
    }

    fun updateTransaction(transaction: Transaction) {
        viewModelScope.launch {
            repository.updateTransaction(transaction)
        }
    }

    fun deleteTransaction(transaction: Transaction) {
        viewModelScope.launch {
            repository.deleteTransaction(transaction)
        }
    }
}