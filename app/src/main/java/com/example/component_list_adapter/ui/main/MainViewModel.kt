package com.example.component_list_adapter.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.component_list_adapter.network.model.Component
import com.example.component_list_adapter.repository.ComponentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    componentRepo: ComponentRepo
) : ViewModel() {

    val components = MutableLiveData<List<Component>>()

    init {
        viewModelScope.launch {
            components.value = componentRepo.getComponents()
        }
    }

}