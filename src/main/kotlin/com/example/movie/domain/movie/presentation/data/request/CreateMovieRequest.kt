package com.example.movie.domain.movie.presentation.data.request

import java.time.LocalDate

data class CreateMovieRequest(
    val title: String,
    val description: String,
    val openingDate: LocalDate,
    val posterImg: String,
)
