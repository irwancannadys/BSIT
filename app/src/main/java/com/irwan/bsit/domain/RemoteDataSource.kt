package com.irwan.bsit.domain

import com.irwan.bsit.model.ProfileResponse
import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getTransaction() : Response<List<TransactionResponse>>
    suspend fun getProfile() : Response<ProfileResponse>
}