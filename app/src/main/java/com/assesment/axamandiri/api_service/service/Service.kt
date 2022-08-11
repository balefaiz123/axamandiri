package com.assesment.axamandiri.api_service.service

import com.assesment.axamandiri.common.entity.DataResponse
import com.assesment.axamandiri.common.entity.DataResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("photos")
    suspend fun getAllData(): Response<ArrayList<DataResponseItem>>

}