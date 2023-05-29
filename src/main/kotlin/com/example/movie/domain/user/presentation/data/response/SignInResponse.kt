package com.example.movie.domain.user.presentation.data.response

import java.util.UUID

data class SignInResponse(
    val succStatus: Boolean,
    val userUUID: UUID
)