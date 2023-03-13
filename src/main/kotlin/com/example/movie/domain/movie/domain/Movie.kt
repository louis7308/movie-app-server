package com.example.movie.domain.movie.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val title: String,

    val description: String,

    val openingDate: LocalDate,

    val posterImg: String,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = [CascadeType.REMOVE])
    val likes: List<Likes> = mutableListOf(),
)