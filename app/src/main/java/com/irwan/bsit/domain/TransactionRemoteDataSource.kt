package com.irwan.bsit.domain

import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response

interface TransactionRemoteDataSource {

    suspend fun getTransaction() : Response<List<TransactionResponse>>
}