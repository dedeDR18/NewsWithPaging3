package com.example.newswithpaging3.data.remote.dto

data class ResponseDto(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)