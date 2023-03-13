package com.example.movie.domain.movie.presentation.data.dto

import java.time.LocalDate

data class FindAllMovieListDto(
    val id: Long,
    val title: String,
    val openingDate: String,
    val posterImg: String,
    val likes: Int
)