package com.amanalli.api.domain.product

import java.text.Normalizer

enum class CategoryProduct(val categoryEsp: String, val categoryEng: String) {
    CERAMICA("Cerámica", "Ceramic"),
    TEXTIL("Textil", "Textile"),
    DECORACION("Decoración", "Decoration"),
    JOYERIA("Joyería", "Jewelry"),
    MADERA("Madera", "Wood"),
    ALEBRIJES("Alebrijes", "Alebrijes");

    companion object {
        fun fromString(value: String): CategoryProduct? {
            val normalized = value.normalize()
            return entries.find {
                it.categoryEsp.equals(normalized, ignoreCase = true) ||
                        it.categoryEsp.normalize().equals(normalized, ignoreCase = true)
            }
        }

        // function to normalize text by removing accents
        private fun String.normalize(): String =
            Normalizer.normalize(this, Normalizer.Form.NFD)
                .replace(Regex("\\p{M}"), "")
                .lowercase()
    }
}
