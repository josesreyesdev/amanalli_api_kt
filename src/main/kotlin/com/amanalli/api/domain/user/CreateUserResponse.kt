package com.amanalli.api.domain.user

data class CreateUserResponse(
    val id: Long,
    val fullName: String,
    val phoneNumber: String,
    val email: String
)
