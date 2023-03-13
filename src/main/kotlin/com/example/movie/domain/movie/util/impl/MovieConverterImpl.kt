package com.example.movie.domain.movie.util.impl

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
import com.example.movie.domain.movie.util.MovieConverter
import org.springframework.stereotype.Component
import java.time.format.DateTimeFormatter

@Component
class MovieConverterImpl(

) : MovieConverter {
    override fun toDto(movie: Movie): FindAllMovieListDto =
        FindAllMovieListDto(
            id = movie.id,
            title = movie.title,
            openingDate = movie.openingDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
            posterImg = movie.posterImg,
            likes = movie.likes.size
        )

    override fun toResponse(dto: FindAllMovieListDto): FindAllMovieListResponse =
        FindAllMovieListResponse(
            id = dto.id,
            title = dto.title,
            openingDate = dto.openingDate,
            posterImg = dto.posterImg,
            likes = dto.likes
        )

    override fun toDto(movie: Movie?): FindMovieDetailDto =
        FindMovieDetailDto(
            id = movie?.id,
            title = movie?.title,
            description = movie?.description,
            openingDate = movie?.openingDate?.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
            posterImg = movie?.posterImg,
            likes = movie?.likes?.size
        )

    override fun toResponse(dto: FindMovieDetailDto): FindMovieDetailResponse =
        FindMovieDetailResponse(
            id = dto.id,
            title = dto.title,
            description = dto.description,
            openingDate = dto.openingDate,
            posterImg = dto.posterImg,
            likes = dto.likes
        )

    override fun toDto(likes: Likes): FindLikeMyMovieDto =
        FindLikeMyMovieDto(
            id = likes.movie.id,
            title = likes.movie.title,
            description = likes.movie.description,
            openingDate = likes.movie.openingDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
            posterImg = likes.movie.posterImg
        )

    override fun toResponse(dto: FindLikeMyMovieDto): FindLikeMyMovieResponse =
        FindLikeMyMovieResponse(
            id = dto.id,
            title = dto.title,
            description = dto.description,
            openingDate = dto.openingDate,
            posterImg = dto.posterImg
        )

    override fun toEntity(createMovieRequest: CreateMovieRequest): Movie =
        Movie(
            id = 0,
            title = createMovieRequest.title,
            description = createMovieRequest.description,
            openingDate = createMovieRequest.openingDate,
            posterImg = createMovieRequest.posterImg,
            likes = mutableListOf()
        )

    override fun toResponse(dto: CreateMovieDto): CreateMovieResponse =
        CreateMovieResponse(
            succStatus = dto.succStatus
        )
}

