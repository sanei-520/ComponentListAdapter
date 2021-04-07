package com.example.component_list_adapter.util

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.component_list_adapter.R
import com.example.component_list_adapter.databinding.ComponentBannerBinding
import com.example.component_list_adapter.databinding.ComponentIndexBarBinding
import com.example.component_list_adapter.databinding.ComponentNewsBinding
import com.example.component_list_adapter.network.model.Component
import com.example.component_list_adapter.network.model.ComponentType
import com.example.component_list_adapter.ui.general.*

object ComponentUtil {

    fun getComponentType(component: Component): Int {
        return when(component.type) {
            ComponentType.banner -> {
                R.layout.component_banner
            }
            ComponentType.news -> {
                R.layout.component_news
            }
            ComponentType.indexBar -> {
                R.layout.component_index_bar
            }
        }
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        return when(viewType) {
            R.layout.component_banner -> {
                BannerViewHolder(
                    ComponentBannerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.component_news -> {
                NewsViewHolder(
                    ComponentNewsBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.component_index_bar -> {
                IndexBarViewHolder(
                    ComponentIndexBarBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw UnsupportedOperationException("Unknown view")
        }
    }
}