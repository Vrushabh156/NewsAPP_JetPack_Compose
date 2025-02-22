package com.vrushabh.newsapp_jetpack_compose.di

import android.app.Application
import com.vrushabh.newsapp_jetpack_compose.data.manger.LocalUserMangerImpl
import com.vrushabh.newsapp_jetpack_compose.domain.manger.LocalUserManger
import com.vrushabh.newsapp_jetpack_compose.domain.usecases.app_entry.AppEntryUseCases
import com.vrushabh.newsapp_jetpack_compose.domain.usecases.app_entry.ReadAppEntry
import com.vrushabh.newsapp_jetpack_compose.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}