package com.irwan.bsit.domain.repository

import com.irwan.bsit.model.ProfileResponse
import com.irwan.bsit.model.TransactionResponse
import retrofit2.Response

interface Repository {
    suspend fun getTransaction() : Response<List<TransactionResponse>>
    suspend fun getProfile() : Response<ProfileResponse>

}