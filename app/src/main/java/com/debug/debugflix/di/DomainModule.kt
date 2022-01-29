package com.debug.debugflix.di

import com.debug.debugflix.data.DiscoveryRepository
import com.debug.debugflix.data.DiscoveryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsDiscoveryRepository(
        discoveryRepositoryImpl: DiscoveryRepositoryImpl
    ): DiscoveryRepository
}