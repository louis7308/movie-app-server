package com.example.movie.domain.user.presentation

import com.example.movie.domain.user.presentation.data.request.SignInRequest
import com.example.movie.domain.user.presentation.data.request.SignUpReqeust
import com.example.movie.domain.user.presentation.data.response.MyProfileResponse
import com.example.movie.domain.user.presentation.data.response.SignInResponse
import com.example.movie.domain.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody signUpRequest: SignUpReqeust) =
        userService.signUp(signUpRequest)

    @PostMapping("/signin")
    fun signIn(@RequestBody signInRequest: SignInRequest): SignInResponse =
        userService.signIn(signInRequest)

    @GetMapping("/info/{uuid}")
    fun myProfile(@PathVariable("uuid") uuid: String): MyProfileResponse =
        userService.myProfile(uuid)
}