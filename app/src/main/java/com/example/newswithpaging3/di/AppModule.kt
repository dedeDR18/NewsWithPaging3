package com.example.newswithpaging3.di


import com.example.newswithpaging3.data.NewsRepositoryImpl
import com.example.newswithpaging3.data.remote.NewsService
import com.example.newswithpaging3.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(api: NewsService): NewsRepository {
        return NewsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideNewsService(): NewsService {
        return Retrofit.Builder()
            .baseUrl(NewsService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)
    }
}