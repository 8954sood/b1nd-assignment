package com.hu.b1nd.di.module

import android.content.Context
import androidx.room.Room
import com.hu.b1nd.local.dao.LostDao
import com.hu.b1nd.local.database.B1ndAssignmentDataBase
import com.hu.b1nd.local.table.B1ndAssignment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun providesB1ndAssignmentDataBase(
        @ApplicationContext context: Context
    ): B1ndAssignmentDataBase = Room
        .databaseBuilder(
            context,
            B1ndAssignmentDataBase::class.java,
            B1ndAssignment.DATABASE
        ).build()

    @Provides
    @Singleton
    fun providesLostDao(
        b1ndAssignmentDataBase: B1ndAssignmentDataBase
    ): LostDao = b1ndAssignmentDataBase.lostDao()
}