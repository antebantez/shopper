package io.github.antebantez.shopper.shoppingList.api

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateShoppingListRequest (

    @field:NotBlank(message = "Name is required")
    @field:Size(max = 255, message = "Name must not exceed 255 characters.")
    val name: String
)