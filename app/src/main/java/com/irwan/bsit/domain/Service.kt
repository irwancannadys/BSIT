package com.irwan.bsit.domain

import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("questions")
    suspend fun getTransaction() : Response<List<TransactionResponse>>
}