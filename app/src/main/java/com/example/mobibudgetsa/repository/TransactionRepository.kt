package com.example.mobibudgetsa.repository

import com.example.mobibudgetsa.data.dao.TransactionDao
import com.example.mobibudgetsa.model.Transaction

class TransactionRepository(
    private val transactionDao: TransactionDao
) {

    suspend fun getTransactionsForUser(userId: Int): List<Transaction> {
        return transactionDao.getTransactionsForUser(userId)
    }

    suspend fun addTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    suspend fun updateTransaction(transaction: Transaction) {
        transactionDao.updateTransaction(transaction)
    }

    suspend fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction)
    }

    suspend fun getUnsyncedTransactions(): List<Transaction> {
        return transactionDao.getUnsyncedTransactions()
    }
}