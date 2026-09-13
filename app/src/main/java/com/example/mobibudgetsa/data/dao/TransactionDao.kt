package com.example.mobibudgetsa.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mobibudgetsa.model.Transaction

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transactions")
    suspend fun getAllTransactions(): List<Transaction>

    @Insert
    suspend fun insertTransaction(transaction: Transaction)

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions WHERE userId = :userId")
    suspend fun getTransactionsForUser(userId: Int): List<Transaction>

    @Query("SELECT * FROM transactions WHERE synced = 0")
    suspend fun getUnsyncedTransactions(): List<Transaction>
}