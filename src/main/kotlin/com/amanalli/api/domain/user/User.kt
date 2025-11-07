package com.amanalli.api.domain.user

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "users")
@Entity(name = "User")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "full_name", nullable = false, length = 100)
    val fullName: String,

    @Column(name = "phone_number", nullable = false, unique = true, length = 20)
    val phoneNumber: String,

    @Column(name = "email", nullable = false, unique = true, length = 100)
    val email: String,

    @Column(name = "password", nullable = false, length = 100)
    val password: String,

    @Column(name = "active", nullable = false)
    val active: Boolean,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime,

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
