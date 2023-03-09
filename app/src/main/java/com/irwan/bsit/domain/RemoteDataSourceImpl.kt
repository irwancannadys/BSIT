package com.irwan.bsit.domain

import com.irwan.bsit.model.ProfileResponse
import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: Service
) : RemoteDataSource {

    override suspend fun getTransaction(): Response<List<TransactionResponse>> {
        return service.getTransaction()
    }

    override suspend fun getProfile(): Response<ProfileResponse> =
        service.getProfile()
}