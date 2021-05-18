package com.example.kata

object Context {
    val isMock = System.getenv("mock")?.toBoolean() ?: true
}