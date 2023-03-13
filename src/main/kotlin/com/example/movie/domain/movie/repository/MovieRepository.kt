package com.example.movie.domain.movie.repository

import com.example.movie.domain.movie.domain.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<Movie, Long> {
    fun existsByTitle(title: String): Boolean
}