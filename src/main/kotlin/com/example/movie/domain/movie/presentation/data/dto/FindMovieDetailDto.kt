package com.example.movie.domain.movie.presentation.data.dto

data class FindMovieDetailDto(
    val id: Long?,
    val title: String?,
    val openingDate: String?,
    val description: String?,
    val posterImg: String?,
    val likes: Int?
)