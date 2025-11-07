package com.amanalli.api.controller

import com.amanalli.api.domain.user.CreateUserRequest
import com.amanalli.api.domain.user.CreateUserResponse
import com.amanalli.api.domain.user.UserService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    @Transactional
    fun createUser(
        @Valid @RequestBody createUserRequest: CreateUserRequest,
        uri: UriComponentsBuilder
    ): ResponseEntity<CreateUserResponse> {
        val createUserResponse: CreateUserResponse = userService.createUser(createUserRequest)
        val url = uri.path("/users/{id}").buildAndExpand(createUserResponse.id).toUri()
        return ResponseEntity.created(url).body(createUserResponse)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<CreateUserResponse> {
        val response = userService.getUserById(id)
        return ResponseEntity.ok(response)
    }
}