package com.example.newswithpaging3.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newswithpaging3.data.remote.NewsService
import com.example.newswithpaging3.domain.model.Article

import retrofit2.HttpException
import java.io.IOException

class HeadlinePagingSource(private val newsService: NewsService) : PagingSource<Int, Article>(){
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1

        return try {
            val response = newsService.getHeadlineNews("id", "technology", 5, page)

            LoadResult.Page(
                data = response?.articles.map { it.toArticle() },
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if(response?.articles.isEmpty()) null else page.plus(1)
            )

        }catch (e: IOException){
            return LoadResult.Error(e)
        }catch (e: HttpException){
            return LoadResult.Error(e)
        }
    }
}