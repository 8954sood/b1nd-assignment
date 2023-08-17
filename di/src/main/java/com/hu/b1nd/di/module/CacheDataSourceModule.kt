package com.hu.b1nd.di.module

import com.hu.b1nd.data.datasource.lost.LostCacheDataSource
import com.hu.b1nd.local.datasource.LostCacheDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CacheDataSourceModule {

    @Singleton
    @Binds
    abstract fun providesLostCacheDataSource(
        lostCacheDataSourceImpl: LostCacheDataSourceImpl
    ): LostCacheDataSource
}