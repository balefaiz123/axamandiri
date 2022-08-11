package com.assesment.axamandiri.activity.module

import android.content.Context
import com.assesment.axamandiri.api_service.RetrofitClient
import com.assesment.axamandiri.api_service.service.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context) = RetrofitClient.getClient(context)

    @Provides
    @Singleton
    fun provideDataService(retrofit: Retrofit) = retrofit.create(Service::class.java)

}