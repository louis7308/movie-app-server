package com.example.movie.domain.user.repository

import com.example.movie.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, String> {
    fun existsByUserId(id: String): Boolean

    fun findByUuid(uuid: UUID): User?

    fun findByUserId(userId: String): User?

}