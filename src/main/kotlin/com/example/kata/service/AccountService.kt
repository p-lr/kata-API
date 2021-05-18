package com.example.kata.service

import com.example.kata.dao.AccountDao
import com.example.kata.models.DepositData
import com.example.kata.models.Transaction
import com.example.kata.models.WithdrawData
import kotlinx.coroutines.flow.toList

/**
 * This service enables account deposit, withdrawal, and history checking.
 */
class AccountService(
    private val accountDao: AccountDao,
) {
    suspend fun makeDeposit(depositData: DepositData): Boolean {
        return with(depositData) {
            accountDao.makeDeposit(id, amount)
        }
    }

    suspend fun makeWithdraw(withdrawData: WithdrawData): Boolean {
        return with(withdrawData) {
            accountDao.makeWithdraw(id, amount)
        }
    }

    suspend fun getAccountHistory(id: String): List<Transaction> {
        return accountDao.getTransactions(id).toList()
    }
}