package com.example.movie.domain.movie.service

import com.example.movie.domain.movie.presentation.data.dto.CreateMovieDto
import com.example.movie.domain.movie.presentation.data.dto.FindAllMovieListDto
import com.example.movie.domain.movie.presentation.data.dto.FindLikeMyMovieDto
import com.example.movie.domain.movie.presentation.data.dto.FindMovieDetailDto
import com.example.movie.domain.movie.presentation.data.request.CreateMovieRequest
import com.example.movie.domain.movie.presentation.data.response.AddLikeResponse

interface MovieService {
    fun findAll(): List<FindAllMovieListDto>

    fun findMovie(id: Long): FindMovieDetailDto

    fun addLike(movieId: Long, userId: String): AddLikeResponse

    fun findMyMovieFromLike(uuid: String): List<FindLikeMyMovieDto>

    fun createMovie(createMovieRequest: CreateMovieRequest): CreateMovieDto
}