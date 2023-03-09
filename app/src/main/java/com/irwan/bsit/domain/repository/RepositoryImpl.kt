package com.irwan.bsit.domain.repository

import com.irwan.bsit.domain.RemoteDataSource
import com.irwan.bsit.model.ProfileResponse
import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override suspend fun getTransaction(): Response<List<TransactionResponse>> {
        return remoteDataSource.getTransaction()
    }

    override suspend fun getProfile(): Response<ProfileResponse> =
        remoteDataSource.getProfile()
}