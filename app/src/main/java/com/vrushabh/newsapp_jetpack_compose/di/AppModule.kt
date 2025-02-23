package com.vrushabh.newsapp_jetpack_compose.di

import android.app.Application
import androidx.room.Room
import com.vrushabh.newsapp_jetpack_compose.data.local.NewsDao
import com.vrushabh.newsapp_jetpack_compose.data.local.NewsDatabase
import com.vrushabh.newsapp_jetpack_compose.data.local.NewsTypeConvertor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import com.vrushabh.newsapp_jetpack_compose.data.remote.NewsApi
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
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}

