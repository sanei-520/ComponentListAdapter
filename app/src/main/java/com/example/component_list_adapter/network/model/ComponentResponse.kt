package com.example.component_list_adapter.network.model

import com.google.gson.annotations.SerializedName

data class ComponentResponse(

    @SerializedName("components")
    val components: List<Component>

)
