package com.example.movie.domain.user.util.impl

import com.example.movie.domain.user.domain.User
import com.example.movie.domain.user.presentation.data.request.SignUpReqeust
import com.example.movie.domain.user.util.UserConverter
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserConverterimpl(

): UserConverter {
    override fun toEntity(signUpReqeust: SignUpReqeust): User =
        User(
            uuid = UUID.randomUUID(),
            userId = signUpReqeust.id,
            password = signUpReqeust.password,
            name = signUpReqeust.name
        )
}