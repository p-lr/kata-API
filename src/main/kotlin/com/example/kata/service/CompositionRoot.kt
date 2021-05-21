package com.example.kata.service

import com.example.kata.dao.AccountDaoMock

fun makeAccountService(isMock: Boolean): AccountService {
    return if (isMock) {
        /* For the sake of simplicity, the mock source is part of this module. In a real app, it would be imported e.g
         * as an OSGI plugin. */
        AccountService(AccountDaoMock())
    } else {
        /* Real application would instantiate a service using a real DAO */
        TODO()
    }
}