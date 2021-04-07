package com.example.component_list_adapter.repository

import com.example.component_list_adapter.network.ComponentService
import com.example.component_list_adapter.network.model.Component

class ComponentRepoImpl constructor(
    private val componentService: ComponentService
): ComponentRepo {

    override suspend fun getComponents(): List<Component> {
        return componentService.getComponents().components
    }

}