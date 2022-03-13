package com.example.newswithpaging3.domain.repository

import androidx.paging.PagingData
import com.example.newswithpaging3.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getHeadlineStream(): Flow<PagingData<Article>>
}