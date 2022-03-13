package com.example.newswithpaging3.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newswithpaging3.data.remote.NewsService
import com.example.newswithpaging3.domain.model.Article
import com.example.newswithpaging3.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsService: NewsService) : NewsRepository {

    override fun getHeadlineStream(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 5, enablePlaceholders = false),
            pagingSourceFactory = { HeadlinePagingSource(newsService) }
        ).flow
    }
}