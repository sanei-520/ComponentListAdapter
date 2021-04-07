package com.example.component_list_adapter.ui.index

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.component_list_adapter.databinding.IndexBarItemBinding
import com.example.component_list_adapter.network.model.index.Index
import com.example.component_list_adapter.ui.index.IndexAdapter.IndexViewHolder

class IndexAdapter : ListAdapter<Index, IndexViewHolder>(DiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndexViewHolder {
        return IndexViewHolder(
            IndexBarItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: IndexViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class IndexViewHolder(
        private val binding: IndexBarItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(index: Index) {
            binding.apply {
                name.text = index.name
                value.text = index.value.toString()
            }
        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Index>() {
        override fun areItemsTheSame(oldItem: Index, newItem: Index) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Index, newItem: Index) =
            oldItem == newItem
    }
}