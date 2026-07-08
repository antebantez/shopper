package io.github.antebantez.shopper.shoppingList

import org.springframework.stereotype.Service

@Service
class ShoppingListService(
    private val shoppingListRepository: ShoppingListRepository
) {

    fun getAll(): List<ShoppingList> =
        shoppingListRepository.findAll()

    fun create(name: String): ShoppingList {
        val shoppingList = ShoppingList(name = name)
        return shoppingListRepository.save(shoppingList)
    }
}