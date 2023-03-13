package com.example.movie.domain.user.util

import com.example.movie.domain.user.domain.User
import com.example.movie.domain.user.presentation.data.request.SignUpReqeust

interface UserConverter {
    fun toEntity(signUpReqeust: SignUpReqeust): User
}