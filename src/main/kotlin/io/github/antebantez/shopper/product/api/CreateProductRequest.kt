package io.github.antebantez.shopper.product.api

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateProductRequest(
    @field:NotBlank(message = "Name is required")
    @field:Size(max = 255, message = "Name must not exceed 255 characters.")
    val name: String
)