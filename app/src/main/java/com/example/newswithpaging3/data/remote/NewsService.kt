package com.example.newswithpaging3.data.remote

import com.example.newswithpaging3.data.remote.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines?apiKey=c3749351b52445edaa3e0f9fa150958c")
   suspend fun getHeadlineNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page:Int
    ): ResponseDto

    companion object{
        const val BASE_URL = "https://newsapi.org/v2/"
    }

}