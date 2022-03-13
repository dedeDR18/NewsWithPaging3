package com.example.newswithpaging3.data.remote.dto

import com.example.newswithpaging3.domain.model.Source

data class Source(
    val id: String,
    val name: String
){
    fun toSource():Source{
        return Source(
            id = id,
            name = name
        )
    }
}