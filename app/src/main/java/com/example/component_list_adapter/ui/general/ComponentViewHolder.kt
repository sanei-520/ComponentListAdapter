package com.example.component_list_adapter.ui.general

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.component_list_adapter.databinding.ComponentBannerBinding
import com.example.component_list_adapter.databinding.ComponentIndexBarBinding
import com.example.component_list_adapter.databinding.ComponentNewsBinding
import com.example.component_list_adapter.network.model.Banner
import com.example.component_list_adapter.network.model.Component
import com.example.component_list_adapter.network.model.ComponentType
import com.example.component_list_adapter.network.model.News
import com.example.component_list_adapter.network.model.index.IndexBar
import com.example.component_list_adapter.ui.index.IndexAdapter
import com.google.gson.Gson

abstract class ComponentViewHolder(view: View): RecyclerView.ViewHolder(view) {

    abstract fun bind(component: Component)

}

class BannerViewHolder(
    private val binding: ComponentBannerBinding
) : ComponentViewHolder(binding.root) {
    override fun bind(component: Component) {
        if (component.type == ComponentType.banner) {
            try {
                val banner = Gson().fromJson(
                    Gson().toJson(component.detail),
                    Banner::class.java
                )
                binding.apply {
                    Glide
                        .with(binding.root.context)
                        .load(banner.image)
                        .centerCrop()
                        .into(bannerImage);
                }
            } catch (e: Exception) {
                Log.e("Component Adapter", e.message.toString())
            }
        }
    }
}

class NewsViewHolder(
    private val binding: ComponentNewsBinding
) : ComponentViewHolder(binding.root) {
    override fun bind(component: Component) {
        Log.d("News", component.detail.toString())
        try {
            val news = Gson().fromJson(Gson().toJson(component.detail), News::class.java)
            binding.apply {
                headline.text = news.headline
                content.text = news.content
            }
        } catch (e: Exception) {
            Log.e("Component Adapter", e.message.toString())
        }
    }
}

class IndexBarViewHolder(
    private val binding: ComponentIndexBarBinding
) : ComponentViewHolder(binding.root) {
    override fun bind(component: Component) {
        try {
            val indexBar = Gson().fromJson(
                Gson().toJson(component.detail),
                IndexBar::class.java
            )
            val indexAdapter = IndexAdapter()
            val manager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            binding.apply {
                indexBarRecyclerView.apply {
                    adapter = indexAdapter
                    layoutManager = manager
                }
            }

            indexAdapter.submitList(indexBar.indexList)
        } catch (e: Exception) {
            Log.e("Component Adapter", e.message.toString())
        }
    }
}