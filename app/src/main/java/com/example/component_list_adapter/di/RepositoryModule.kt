package com.example.component_list_adapter.di

import com.example.component_list_adapter.network.ComponentService
import com.example.component_list_adapter.repository.ComponentRepo
import com.example.component_list_adapter.repository.ComponentRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideComponentRepository(
        componentService: ComponentService
    ): ComponentRepo{
        return ComponentRepoImpl(componentService)
    }

}
