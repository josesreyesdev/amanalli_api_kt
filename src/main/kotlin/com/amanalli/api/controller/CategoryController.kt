package com.amanalli.api.controller

import com.amanalli.api.domain.category.CategoryService
import com.amanalli.api.domain.category.CreateCategoryRequest
import com.amanalli.api.domain.category.CategoryResponse
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/categories")
class CategoryController(private val categoryService: CategoryService) {

    @PostMapping
    @Transactional
    fun createCategory(
        @Valid @RequestBody createCategoryRequest: CreateCategoryRequest,
        uri: UriComponentsBuilder
    ): ResponseEntity<CategoryResponse> {
        val createdCategory = categoryService.createCategory(createCategoryRequest)
        val url = uri.path("/categories/{id}").buildAndExpand(createdCategory.id).toUri()
        return ResponseEntity.created(url).body(createdCategory)
    }

    @GetMapping
    fun getCategories(): ResponseEntity<List<CategoryResponse>> {
        return ResponseEntity.ok(categoryService.getCategories())
    }
}