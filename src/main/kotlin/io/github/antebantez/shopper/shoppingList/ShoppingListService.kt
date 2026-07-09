package io.github.antebantez.shopper.shoppingList

import io.github.antebantez.shopper.common.exception.ShoppingListNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID

@Service
class ShoppingListService(
    private val shoppingListRepository: ShoppingListRepository
) {

    fun getAll(): List<ShoppingList> =
        shoppingListRepository.findAll()

    fun getById(id: UUID): ShoppingList =
        shoppingListRepository.findById(id).orElseThrow{ ShoppingListNotFoundException(id) }

    fun create(name: String): ShoppingList {
        val shoppingList = ShoppingList(name = name)
        return shoppingListRepository.save(shoppingList)
    }

    fun update(id: UUID, name: String): ShoppingList {
        val shoppingList = getById(id)

        shoppingList.name = name
        shoppingList.updatedAt = Instant.now()

        return shoppingListRepository.save(shoppingList)
    }

    fun delete(id: UUID) {
        val shoppingList = getById(id)
        shoppingListRepository.delete(shoppingList)
    }
}