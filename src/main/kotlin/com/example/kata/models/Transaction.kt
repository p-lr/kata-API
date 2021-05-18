package com.example.kata.models

import java.util.*

sealed class Transaction {
    abstract val id: String
    abstract val date: Long
    abstract val balance: Double
}

data class DepositTransaction(
    override val id: String,
    override val date: Long,
    override val balance: Double,
    val amount: Double,
) : Transaction()

data class WithdrawTransaction(
    override val id: String,
    override val date: Long,
    override val balance: Double,
    val amount: Double,
) : Transaction()