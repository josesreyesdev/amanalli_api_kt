package com.amanalli.api.domain.user

import java.time.LocalDateTime

object UserMapper {
    fun CreateUserRequest.toUser(): User = User(
        id = this.id,
        fullName = this.fullName,
        phoneNumber = this.phoneNumber,
        email = this.email,
        password = this.password,
        active = true,
        createdAt = LocalDateTime.now()
    )

    fun User.toResponse(): CreateUserResponse = CreateUserResponse(
        id = this.id ?: 0,
        fullName = this.fullName,
        phoneNumber = this.phoneNumber,
        email = this.email
    )
}
