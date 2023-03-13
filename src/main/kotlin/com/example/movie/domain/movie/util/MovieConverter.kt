package com.example.movie.domain.movie.util

import com.example.movie.domain.movie.domain.Likes
import com.example.movie.domain.movie.domain.Movie
import com.example.movie.domain.movie.presentation.data.dto.CreateMovieDto
import com.example.movie.domain.movie.presentation.data.dto.FindAllMovieListDto
import com.example.movie.domain.movie.presentation.data.dto.FindLikeMyMovieDto
import com.example.movie.domain.movie.presentation.data.dto.FindMovieDetailDto
import com.example.movie.domain.movie.presentation.data.request.CreateMovieRequest
import com.example.movie.domain.movie.presentation.data.response.CreateMovieResponse
import com.example.movie.domain.movie.presentation.data.response.FindAllMovieListResponse
import com.example.movie.domain.movie.presentation.data.response.FindLikeMyMovieResponse
import com.example.movie.domain.movie.presentation.data.response.FindMovieDetailResponse

interface MovieConverter {
    fun toDto(movie: Movie): FindAllMovieListDto

    fun toResponse(dto: FindAllMovieListDto): FindAllMovieListResponse

    fun toDto(movie: Movie?): FindMovieDetailDto

    fun toResponse(dto: FindMovieDetailDto): FindMovieDetailResponse

    fun toDto(likes: Likes): FindLikeMyMovieDto

    fun toResponse(dto: FindLikeMyMovieDto): FindLikeMyMovieResponse

    fun toEntity(createMovieRequest: CreateMovieRequest): Movie

    fun toResponse(dto: CreateMovieDto): CreateMovieResponse
}