package com.example.component_list_adapter.network

import com.example.component_list_adapter.network.model.ComponentResponse
import retrofit2.http.GET

interface ComponentService {

    @GET("component.json")
    suspend fun getComponents(): ComponentResponse

}