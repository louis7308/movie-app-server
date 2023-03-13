package com.example.movie.domain.movie.repository

import com.example.movie.domain.movie.domain.Likes
import com.example.movie.domain.movie.domain.Movie
import com.example.movie.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface LikeRepository : JpaRepository<Likes, Long> {
    fun findByMovie(movieId: Movie): List<Likes>

    fun findByUser(user: User?): List<Likes>
}