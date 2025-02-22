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
import com.vrushabh.newsapp_jetpack_compose.data.remote.NewsApi
import com.vrushabh.newsapp_jetpack_compose.data.repository.NewsRepositoryImpl
import com.vrushabh.newsapp_jetpack_compose.domain.repository.NewsRepository
import com.vrushabh.newsapp_jetpack_compose.domain.usecases.news.GetNews
import com.vrushabh.newsapp_jetpack_compose.domain.usecases.news.NewsUseCases
import com.vrushabh.newsapp_jetpack_compose.domain.usecases.news.SearchNews
import com.vrushabh.newsapp_jetpack_compose.util.Constants.BASE_URL
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}

