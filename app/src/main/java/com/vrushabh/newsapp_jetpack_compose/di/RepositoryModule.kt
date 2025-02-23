package com.vrushabh.newsapp_jetpack_compose.di

import com.vrushabh.newsapp_jetpack_compose.data.repository.NewsRepositoryImpl
import com.vrushabh.newsapp_jetpack_compose.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

}