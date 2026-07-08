package io.github.antebantez.shopper.shoppingList

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ShoppingListRepository : JpaRepository<ShoppingList, UUID>