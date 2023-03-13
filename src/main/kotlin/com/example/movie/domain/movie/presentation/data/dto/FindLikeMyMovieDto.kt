package com.example.movie.domain.movie.presentation.data.dto

data class FindLikeMyMovieDto(
    val id: Long,
    val title: String,
    val description: String,
    val openingDate: String,
    val posterImg: String,
)