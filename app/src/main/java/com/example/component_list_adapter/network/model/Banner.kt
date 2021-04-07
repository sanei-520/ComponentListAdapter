package com.example.component_list_adapter.network.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("banner-id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String
)
