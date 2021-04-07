package com.example.component_list_adapter.di

import com.example.component_list_adapter.network.ComponentService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideComponentService(): ComponentService {
        return Retrofit.Builder()
            .baseUrl("https://hkettest.s3-ap-southeast-1.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ComponentService::class.java)
    }

}