package com.example.movie.domain.user.domain

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val uuid: UUID,

    val userId: String,

    val password: String,

    val name: String
)