package com.example.movie.domain.movie.presentation

import com.example.movie.domain.movie.presentation.data.request.CreateMovieRequest
import com.example.movie.domain.movie.presentation.data.request.UserIdRequest
import com.example.movie.domain.movie.presentation.data.response.*
import com.example.movie.domain.movie.service.MovieService
import com.example.movie.domain.movie.util.MovieConverter
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/movie")
class MovieController(
    private val movieService: MovieService,
    private val movieConverter: MovieConverter
) {
    @GetMapping
    fun findAll(): List<FindAllMovieListResponse> =
        movieService.findAll()
            .map { movieConverter.toResponse(it) }

    @GetMapping("/{movie_id}")
    fun findMovieDetail(@PathVariable("movie_id") movieId: Long): FindMovieDetailResponse =
        movieService.findMovie(movieId)
            .let { movieConverter.toResponse(it) }

    @PostMapping("/likes")
    fun addMovieLike(@RequestBody userIdRequest: UserIdRequest): AddLikeResponse =
        movieService.addLike(userIdRequest.movieId, userIdRequest.userId)

    @GetMapping("/likes/{uuid}")
    fun getMyMovieFromLike(@PathVariable("uuid") uuid: String): List<FindLikeMyMovieResponse> =
        movieService.findMyMovieFromLike(uuid)
            .map { movieConverter.toResponse(it) }


    @PostMapping
    fun createMovie(@RequestBody createMovieRequest: CreateMovieRequest): CreateMovieResponse =
        movieService.createMovie(createMovieRequest)
            .let { movieConverter.toResponse(it) }
}