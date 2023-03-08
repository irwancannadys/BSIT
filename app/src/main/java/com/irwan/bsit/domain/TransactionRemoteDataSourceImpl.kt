package com.irwan.bsit.domain

import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response
import javax.inject.Inject

class TransactionRemoteDataSourceImpl @Inject constructor(
    private val service: Service
) : TransactionRemoteDataSource {

    override suspend fun getTransaction(): Response<List<TransactionResponse>> {
        return service.getTransaction()
    }
}