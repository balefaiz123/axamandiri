package com.assesment.axamandiri.api_service.use_case

import com.assesment.axamandiri.api_service.service.Service
import kotlinx.coroutines.flow.flow

class DataUseCase(val service: Service) {

    operator fun invoke() = flow{
        val data = service.getAllData()
        if(data.isSuccessful)
            data?.body()?.let {
                emit(it)
            }
    }
}