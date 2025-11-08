package com.amanalli.api.domain.category

object CategoryMapper {
    fun CreateCategoryRequest.toCategory(): Category = Category(
        id = null,
        name = this.name,
        description = this.description
    )

    fun Category.toResponse() = CategoryResponse(
        id = this.id ?: 0,
        name = this.name,
        description = this.description
    )
}
