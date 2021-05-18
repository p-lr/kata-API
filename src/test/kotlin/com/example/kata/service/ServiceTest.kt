package com.example.kata.service

import com.example.kata.dao.AccountDaoMock
import com.example.kata.models.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class ServiceTest {

    @Test
    fun userStory1() = runBlocking {
        val service = AccountService(AccountDaoMock())

        with(service) {
            makeDeposit(DepositData("john", 150.0))
            makeDeposit(DepositData("amanda", 80.0))
            makeWithdraw(WithdrawData("john", 50.0))
            makeWithdraw(WithdrawData("john", 25.0))

            assertEquals(75.0, getAccountHistory("john").maxByOrNull { it.date }?.balance)
        }
    }

    @Test
    fun userStory2() = runBlocking {
        val service = AccountService(AccountDaoMock())

        with(service) {
            makeWithdraw(WithdrawData("john", 1000.0))
            makeDeposit(DepositData("john", 150.0))
            makeWithdraw(WithdrawData("john", 50.0))

            assertEquals(-900.0, getAccountHistory("john").lastOrNull()?.balance)
        }
    }
}