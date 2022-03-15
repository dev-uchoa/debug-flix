package com.debug.debugflix.network.di

import android.content.Context
import com.debug.debugflix.network.CheckNetworkConnection
import com.debug.debugflix.network.ServiceProvider
import com.debug.debugflix.network.TmdbInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesCheckInternetConnection(
        @ApplicationContext applicationContext: Context
    ) = CheckNetworkConnection(applicationContext)

    @Provides
    fun providesTmdbInterceptor(checkNetworkConnection: CheckNetworkConnection) =
        TmdbInterceptor(checkNetworkConnection)

    @Provides
    fun providesServiceProvider(
        tmdbInterceptor: TmdbInterceptor
    ) = ServiceProvider(tmdbInterceptor)

}