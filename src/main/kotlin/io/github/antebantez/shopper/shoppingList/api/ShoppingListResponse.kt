package io.github.antebantez.shopper.shoppingList.api

import io.github.antebantez.shopper.shoppingList.ShoppingList
import java.time.Instant
import java.util.UUID

data class ShoppingListResponse(
    val id: UUID,
    val name: String,
    val createdAt: Instant,
    val updatedAt: Instant
){
    companion object{
        fun from(shoppingList: ShoppingList) = ShoppingListResponse(
            id = requireNotNull(shoppingList.id),
            name = shoppingList.name,
            createdAt = shoppingList.createdAt,
            updatedAt = shoppingList.updatedAt
        )
    }
}