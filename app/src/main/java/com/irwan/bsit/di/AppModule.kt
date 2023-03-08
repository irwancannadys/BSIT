package com.irwan.bsit.di

import com.irwan.bsit.BuildConfig
import com.irwan.bsit.domain.Service
import com.irwan.bsit.domain.TransactionRemoteDataSource
import com.irwan.bsit.domain.TransactionRemoteDataSourceImpl
import com.irwan.bsit.domain.repository.TransactionRepository
import com.irwan.bsit.domain.repository.TransactionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://private-54eacf-fazztrack.apiary-mock.com/")
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): Service = retrofit.create(Service::class.java)

    @Provides
    @Singleton
    fun provideRepository(transactionRemoteDataSource: TransactionRemoteDataSource): TransactionRepository =
        TransactionRepositoryImpl(transactionRemoteDataSource)

    @Provides
    @Singleton
    fun provideRemoteDataSource(service: Service): TransactionRemoteDataSource =
        TransactionRemoteDataSourceImpl(service)
}