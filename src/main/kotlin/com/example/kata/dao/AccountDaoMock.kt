package com.example.kata.dao

import com.example.kata.models.DepositTransaction
import com.example.kata.models.Transaction
import com.example.kata.models.WithdrawTransaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter

class AccountDaoMock : AccountDao {
    private val transactionList = mutableListOf<Transaction>()

    override suspend fun makeDeposit(id: String, amount: Double): Boolean {
        val newBalance = balanceForUser(id) + amount
        transactionList += DepositTransaction(id, System.nanoTime(), newBalance, amount)
        return true
    }

    override suspend fun makeWithdraw(id: String, amount: Double): Boolean {
        val newBalance = balanceForUser(id) - amount
        transactionList += WithdrawTransaction(id, System.nanoTime(), newBalance, amount)
        return true
    }

    override fun getTransactions(id: String): Flow<Transaction> {
        return transactionList.asFlow().filter { it.id == id }
    }

    private fun balanceForUser(id: String): Double {
        return transactionList.filter { it.id == id }.maxByOrNull { it.date }?.balance ?: 0.0
    }
}