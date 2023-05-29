package com.example.movie.domain.user.presentation.data.response

import com.example.movie.domain.movie.presentation.data.dto.FindLikeMyMovieDto

data class MyProfileResponse(
    val userId: String,
    val name: String,
    val likeMovie: List<FindLikeMyMovieDto>
)