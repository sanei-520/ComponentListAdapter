package com.example.component_list_adapter.network.model.index

import com.google.gson.annotations.SerializedName

data class IndexBar(

    @SerializedName("index-bar-id")
    val id: Int,

    @SerializedName("indexs")
    val indexList: List<Index>

)
