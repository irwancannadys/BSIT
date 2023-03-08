package com.irwan.bsit.domain.repository

import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response

interface TransactionRepository {
    suspend fun getTransaction() : Response<List<TransactionResponse>>
}