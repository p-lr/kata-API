package com.example.kata.routes

import com.example.kata.Context
import com.example.kata.models.DepositData
import com.example.kata.models.WithdrawData
import com.example.kata.service.makeAccountService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.accountRouting() {
    val service = makeAccountService(Context.isMock)

    post("/account/deposit") {
        val depositData = call.receive<DepositData>()
        val response = if (service.makeDeposit(depositData)) {
            HttpStatusCode.Accepted
        } else {
            HttpStatusCode.Forbidden
        }
        call.respond(response)
    }
    post("/account/withdraw") {
        val withdrawData = call.receive<WithdrawData>()
        val response = if (service.makeWithdraw(withdrawData)) {
            HttpStatusCode.Accepted
        } else {
            HttpStatusCode.Forbidden
        }
        call.respond(response)
    }
    get("/account/history/{id}") {
        val id: String = call.parameters["id"] ?: return@get call.respondText(
            "Missing or malformed id",
            status = HttpStatusCode.BadRequest
        )
        val history = service.getAccountHistory(id)
        call.respond(history)
    }
}