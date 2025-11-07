package com.amanalli.api.domain.user

import java.time.LocalDateTime

data class UsersResponse(
    val id: Long,
    val fullName: String,
    val phoneNumber: String,
    val email: String,
    val active: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
