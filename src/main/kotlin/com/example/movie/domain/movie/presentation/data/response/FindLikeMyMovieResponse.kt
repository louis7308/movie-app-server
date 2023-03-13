package com.example.movie.domain.movie.presentation.data.response


data class FindLikeMyMovieResponse(
    val id: Long,
    val title: String,
    val description: String,
    val openingDate: String,
    val posterImg: String,
)