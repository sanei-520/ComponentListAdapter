package com.example.component_list_adapter.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.component_list_adapter.BuildConfig
import com.example.component_list_adapter.network.model.Component
import com.example.component_list_adapter.repository.ComponentRepo
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    componentRepo: ComponentRepo,
    firebaseAnalytics: FirebaseAnalytics
) : ViewModel() {

    val components = MutableLiveData<List<Component>>()

    init {
        viewModelScope.launch {
            components.value = componentRepo.getComponents()
            firebaseAnalytics.logEvent("component_call") {
                param("env", BuildConfig.APPLICATION_ID)
                param("base_url", BuildConfig.BASE_URL)
            }
        }
    }

}