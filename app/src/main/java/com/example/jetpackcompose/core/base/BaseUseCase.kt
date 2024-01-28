package com.example.jetpackcompose.core.base

interface BaseUseCase<In, Out> {
    suspend fun execute(input: In): Out
}