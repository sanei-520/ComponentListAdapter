package com.example.component_list_adapter.network.model

import com.google.gson.annotations.SerializedName

data class News(

    @SerializedName("segment-id")
    val id: Int,

    @SerializedName("headline")
    val headline: String,

    @SerializedName("content")
    val content: String

)
