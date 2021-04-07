package com.example.component_list_adapter.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.component_list_adapter.R
import com.example.component_list_adapter.databinding.ComponentBannerBinding
import com.example.component_list_adapter.databinding.MainFragmentBinding
import com.example.component_list_adapter.ui.general.ComponentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()
    private val componentAdapter = ComponentAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = MainFragmentBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            adapter = componentAdapter
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.components.observe(viewLifecycleOwner) {
            componentAdapter.submitList(it)
        }
    }

}