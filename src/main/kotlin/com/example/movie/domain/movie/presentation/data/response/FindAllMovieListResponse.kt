package com.example.movie.domain.movie.presentation.data.response

import java.time.LocalDate

data class FindAllMovieListResponse(
    val id: Long,
    val title: String,
    val openingDate: String,
    val posterImg: String,
    val likes: Int
)