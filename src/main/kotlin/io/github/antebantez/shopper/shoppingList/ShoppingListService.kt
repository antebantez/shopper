package io.github.antebantez.shopper.shoppingList

import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID

@Service
class ShoppingListService(
    private val shoppingListRepository: ShoppingListRepository
) {

    fun getAll(): List<ShoppingList> =
        shoppingListRepository.findAll()

    fun getById(id: UUID): ShoppingList? =
        shoppingListRepository.findById(id).orElse(null)

    fun create(name: String): ShoppingList {
        val shoppingList = ShoppingList(name = name)
        return shoppingListRepository.save(shoppingList)
    }

    fun update(id: UUID, name: String): ShoppingList? {
        val shoppingList = shoppingListRepository.findById(id).orElse(null)
            ?: return null

        shoppingList.name = name
        shoppingList.updatedAt = Instant.now()

        return shoppingListRepository.save(shoppingList)
    }
}