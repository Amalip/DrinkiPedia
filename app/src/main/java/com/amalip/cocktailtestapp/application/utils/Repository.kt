package com.amalip.cocktailtestapp.application.utils

import com.amalip.cocktailtestapp.application.utils.Either.*
import com.amalip.cocktailtestapp.application.utils.Failure.ServerError
import retrofit2.Call

abstract class Repository {

    fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Right(transform((response.body() ?: default)))
                false -> Left(ServerError)
            }
        } catch (exception: Throwable) {
            Left(ServerError)
        }
    }
}