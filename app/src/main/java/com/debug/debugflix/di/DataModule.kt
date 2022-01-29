package com.debug.debugflix.di

import com.debug.debugflix.data.api.DiscoverAPI
import com.debug.debugflix.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.serialization.ExperimentalSerializationApi

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun providesDiscoverApi(
        serviceProvider: ServiceProvider
    ): DiscoverAPI {
        return serviceProvider.createService(DiscoverAPI::class.java)
    }
}