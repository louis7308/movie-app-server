package com.example.movie.domain.user.service

import com.example.movie.domain.user.presentation.data.request.SignInRequest
import com.example.movie.domain.user.presentation.data.request.SignUpReqeust
import com.example.movie.domain.user.presentation.data.response.SignInResponse

interface UserService {
    fun signUp(signUpReqeust: SignUpReqeust)

    fun signIn(signInRequest: SignInRequest): SignInResponse
}