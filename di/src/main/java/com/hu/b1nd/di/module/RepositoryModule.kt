package com.hu.b1nd.di.module

import com.hu.b1nd.data.repository.LostRepositoryImpl
import com.hu.b1nd.domain.repository.LostRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Singleton
    @Binds
    abstract fun providesLostRepository(
        lostRepositoryImpl: LostRepositoryImpl
    ): LostRepository


}