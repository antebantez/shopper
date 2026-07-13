package io.github.antebantez.shopper.shoppingItem

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ShoppingItemRepository: JpaRepository<ShoppingItem, UUID> {
    fun findAllByShoppingListId(shoppingListId: UUID): List<ShoppingItem>
}