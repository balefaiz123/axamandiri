package com.assesment.axamandiri.activity.module

import com.assesment.axamandiri.api_service.service.Service
import com.assesment.axamandiri.api_service.use_case.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(service: Service) = DataUseCase(service)
}