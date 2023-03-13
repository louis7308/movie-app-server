package com.example.movie.domain.movie.presentation.data.response

import java.time.LocalDate

data class FindMovieDetailResponse(
    val id: Long?,
    val title: String?,
    val openingDate: String?,
    val description: String?,
    val posterImg: String?,
    val likes: Int?
)