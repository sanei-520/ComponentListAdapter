package com.example.component_list_adapter.network.model

import com.google.gson.annotations.SerializedName

data class Component(

    @SerializedName("component-signature")
    val componentSignature: String,

    @SerializedName("type")
    val type: ComponentType,

    @SerializedName("detail")
    val detail: Any


)

enum class ComponentType {
    banner, news, indexBar
}
