package com.example.component_list_adapter.repository

import androidx.lifecycle.LiveData
import com.example.component_list_adapter.network.model.Component
import kotlinx.coroutines.flow.Flow

interface ComponentRepo {

    suspend fun getComponents(): List<Component>

}