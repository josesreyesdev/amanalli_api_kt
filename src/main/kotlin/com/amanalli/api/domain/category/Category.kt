package com.amanalli.api.domain.category

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity(name = "Category")
@Table(name = "categories")
data class Category(
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    val description: String
)
