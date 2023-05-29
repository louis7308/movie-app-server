package com.example.movie.domain.user.service.impl

import com.example.movie.domain.movie.presentation.data.dto.FindLikeMyMovieDto
import com.example.movie.domain.movie.repository.LikeRepository
import com.example.movie.domain.movie.util.MovieConverter
import com.example.movie.domain.user.presentation.data.request.SignInRequest
import com.example.movie.domain.user.presentation.data.request.SignUpReqeust
import com.example.movie.domain.user.presentation.data.response.MyProfileResponse
import com.example.movie.domain.user.presentation.data.response.SignInResponse
import com.example.movie.domain.user.repository.UserRepository
import com.example.movie.domain.user.service.UserService
import com.example.movie.domain.user.util.UserConverter
import org.springframework.stereotype.Service
import java.util.*
import kotlin.RuntimeException

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userConverter: UserConverter,
    private val likeRepository: LikeRepository,
    private val movieConverter: MovieConverter
) : UserService {
    override fun signUp(signUpReqeust: SignUpReqeust) {
        val user = userRepository.existsByUserId(signUpReqeust.id)
        if(user) {
            throw RuntimeException("해당 아이디로 이미 존재하는 유저 입니다.")
        }
        userRepository.save(userConverter.toEntity(signUpReqeust))
    }

    override fun signIn(signInRequest: SignInRequest): SignInResponse {
        val user = userRepository.findByUserId(signInRequest.id) ?: throw RuntimeException("유저가 존재하지 않습니다.")
        if(user.password != signInRequest.password)
            throw RuntimeException("비밀번호가 올바르지 않습니다.")
        return SignInResponse(true, user.uuid)
    }

    override fun myProfile(uuid: String): MyProfileResponse {
        val user = userRepository.findByUuid(UUID.fromString(uuid)) ?: throw RuntimeException("유저가 존재하지 않습니다.")
        val likeList = likeRepository.findByUser(user)
        val myLikeList: MutableList<FindLikeMyMovieDto> = mutableListOf()
        likeList
            .forEach { myLikeList.add(movieConverter.toDto(it)) }
        return MyProfileResponse(user.userId, user.name, myLikeList)
    }
}