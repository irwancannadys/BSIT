package com.irwan.bsit.domain.usecase

import com.irwan.bsit.domain.repository.Repository
import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response
import javax.inject.Inject

class TransactionUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun getTransaction() : Response<List<TransactionResponse>> {
        return repository.getTransaction()
    }
}