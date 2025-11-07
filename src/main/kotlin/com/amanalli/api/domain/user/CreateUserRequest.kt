package com.amanalli.api.domain.user

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateUserRequest(
    val id: Long?,
    @field:NotBlank val fullName: String,
    @field:NotBlank val phoneNumber: String,
    @field:Email val email: String,
    @field:Size(min = 6) val password: String
)
