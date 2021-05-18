package com.example.kata.dao

import com.example.kata.models.Transaction
import kotlinx.coroutines.flow.Flow

interface AccountDao {
    suspend fun makeDeposit(id: String, amount: Double): Boolean
    suspend fun makeWithdraw(id: String, amount: Double): Boolean
    fun getTransactions(id: String): Flow<Transaction>
}