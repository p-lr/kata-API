package com.example.kata.service

import com.example.kata.dao.AccountDaoMock

fun makeAccountService(isMock: Boolean): AccountService {
    return if (isMock) {
        AccountService(AccountDaoMock())
    } else {
        /* Real application would instantiate a service using a real DAO */
        TODO()
    }
}