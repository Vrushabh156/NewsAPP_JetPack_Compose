package com.vrushabh.newsapp_jetpack_compose.di

import com.vrushabh.newsapp_jetpack_compose.data.manger.LocalUserMangerImpl
import com.vrushabh.newsapp_jetpack_compose.domain.manger.LocalUserManger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MangerModule {

    @Binds
    @Singleton
    abstract fun bindLocalUserManger(localUserMangerImpl: LocalUserMangerImpl): LocalUserManger
}