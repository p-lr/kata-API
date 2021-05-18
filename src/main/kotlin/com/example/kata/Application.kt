package com.example.kata

import com.example.kata.routes.accountRouting
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.routing.*
import org.slf4j.event.Level
import java.text.DateFormat


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
            dateFormat = DateFormat.getDateTimeInstance()
        }
    }
    install(CallLogging) {
        level = Level.INFO
    }

    routing {
        accountRouting()
    }
}
