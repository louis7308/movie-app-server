package com.example.movie.domain.movie.service.impl

import com.example.movie.domain.movie.domain.Likes
import com.example.movie.domain.movie.presentation.data.dto.CreateMovieDto
import com.example.movie.domain.movie.presentation.data.dto.FindAllMovieListDto
import com.example.movie.domain.movie.presentation.data.dto.FindLikeMyMovieDto
import com.example.movie.domain.movie.presentation.data.dto.FindMovieDetailDto
import com.example.movie.domain.movie.presentation.data.request.CreateMovieRequest
import com.example.movie.domain.movie.presentation.data.request.UserIdRequest
import com.example.movie.domain.movie.presentation.data.response.AddLikeResponse
import com.example.movie.domain.movie.repository.LikeRepository
import com.example.movie.domain.movie.repository.MovieRepository
import com.example.movie.domain.movie.service.MovieService
import com.example.movie.domain.user.repository.UserRepository
import com.example.movie.domain.movie.util.MovieConverter
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import kotlin.RuntimeException

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val likeRepository: LikeRepository,
    private val userRepository: UserRepository,
    private val movieConverter: MovieConverter
) : MovieService {
    override fun findAll(): List<FindAllMovieListDto> =
        movieRepository.findAll(Sort.by("likes").descending()).distinct()
            .map { movieConverter.toDto(it) }

    override fun findMovie(id: Long): FindMovieDetailDto =
        movieRepository.findByIdOrNull(id)
            .let { movieConverter.toDto(it) }

    override fun addLike(userIdRequest: UserIdRequest): AddLikeResponse {
        val user = userRepository.findByUuid(UUID.fromString(userIdRequest.userId)) ?: throw RuntimeException("유저가 존재하지 않습니다.")
        val movie = movieRepository.findByIdOrNull(userIdRequest.movieId) ?: throw RuntimeException("영화가 존재하지 않습니다.")
        return if(userIdRequest.isChecked) {
            likeRepository.save(Likes(0, movie, user))
            AddLikeResponse(likeRepository.findByMovie(movie).count())
        } else {
            val movieAndUser = likeRepository.findByMovieAndUser(movie, user) ?: throw RuntimeException("유저가 좋아요 누른 영화가 존재하지 않습니다.")
            likeRepository.delete(movieAndUser)
            AddLikeResponse(likeRepository.findByMovie(movie).count())
        }

    }

    override fun findMyMovieFromLike(uuid: String): List<FindLikeMyMovieDto> {
        val user = userRepository.findByUuid(UUID.fromString(uuid)) ?: throw RuntimeException("유저를 찾을 수 없습니다.")
        val likeList = likeRepository.findByUser(user)
        val myLikeList: MutableList<FindLikeMyMovieDto> = mutableListOf()
        likeList
            .forEach { myLikeList.add(movieConverter.toDto(it)) }
        return myLikeList
    }

    override fun createMovie(createMovieRequest: CreateMovieRequest): CreateMovieDto {
        val existsByTitle = movieRepository.existsByTitle(createMovieRequest.title)
        if(existsByTitle) {
            return CreateMovieDto(false)
        }

        val movieEntity = movieConverter.toEntity(createMovieRequest)
        movieRepository.save(movieEntity)
        return CreateMovieDto(true)
    }
}