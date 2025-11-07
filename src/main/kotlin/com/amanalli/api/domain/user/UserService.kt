package com.amanalli.api.domain.user

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(request: CreateUserRequest): CreateUserResponse {
        if (userRepository.existsByPhoneNumber(request.phoneNumber)) {
            throw IllegalArgumentException("Phone number already in use")
        }

        val user: User = UserMapper.run { request.toUser() }
        val saved: User = userRepository.save(user)
        return UserMapper.run { saved.toResponse() }
    }

    fun getUserById(id: Long): CreateUserResponse {
        val user = userRepository.findById(id)
            .orElseThrow { NoSuchElementException("User not found") }
        return UserMapper.run { user.toResponse() }
    }

    fun getUsers(): List<UsersResponse> {
        val users = userRepository.findAll()
        return users.map { UserMapper.run { it.toNewResponse() } }
    }

}

