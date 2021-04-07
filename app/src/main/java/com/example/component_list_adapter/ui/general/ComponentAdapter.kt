package com.example.component_list_adapter.ui.general

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.component_list_adapter.network.model.Component
import com.example.component_list_adapter.util.ComponentUtil


class ComponentAdapter: ListAdapter<Component, ComponentViewHolder>(ComponentDiffUtil) {

    override fun getItemViewType(position: Int): Int {
        val component = getItem(position)
        return ComponentUtil.getComponentType(component)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        return ComponentUtil.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        val component = getItem(position)
        holder.bind(component)
    }

    object ComponentDiffUtil: DiffUtil.ItemCallback<Component>() {
        override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
            return oldItem.componentSignature == newItem.componentSignature
        }

        override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
            return oldItem == newItem
        }
    }
}