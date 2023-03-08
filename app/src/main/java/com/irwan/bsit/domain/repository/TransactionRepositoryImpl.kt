package com.irwan.bsit.domain.repository

import com.irwan.bsit.domain.TransactionRemoteDataSource
import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionRemoteDataSource: TransactionRemoteDataSource
) : TransactionRepository {

    override suspend fun getTransaction(): Response<List<TransactionResponse>> {
        return transactionRemoteDataSource.getTransaction()
    }
}