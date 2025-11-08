package com.amanalli.api.domain.category

class CategoryService(private val categoryRepository: CategoryRepository) {

    fun createCategory(request: CreateCategoryRequest): CategoryResponse {
        if (categoryRepository.existsByName(request.name)) {
            throw IllegalArgumentException("Name already exist")
        }

        val category: Category = CategoryMapper.run { request.toCategory() }
        val saved: Category = categoryRepository.save(category)
        return CategoryMapper.run { saved.toResponse() }
    }

    fun getCategories(): List<CategoryResponse> {
        val categories = categoryRepository.findAll()
        return categories.map { CategoryMapper.run { it.toResponse() } }
    }

}
