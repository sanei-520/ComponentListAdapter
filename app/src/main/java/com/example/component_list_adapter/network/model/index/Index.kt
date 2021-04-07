package com.example.component_list_adapter.network.model.index

import com.google.gson.annotations.SerializedName

data class Index(

    @SerializedName("name")
    val name: String,

    @SerializedName("value")
    val value: Double

)
