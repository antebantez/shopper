package io.github.antebantez.shopper.shoppingList

import io.github.antebantez.shopper.shoppingList.api.CreateShoppingListRequest
import io.github.antebantez.shopper.shoppingList.api.ShoppingListResponse
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/lists")
class ShoppingListController (private val shoppingListService: ShoppingListService){
    @GetMapping
    fun getAll(): List<ShoppingListResponse> =
        shoppingListService.getAll()
            .map(ShoppingListResponse::from)

    @PostMapping
    fun create(@Valid @RequestBody request: CreateShoppingListRequest) :
            ShoppingListResponse =
        shoppingListService.create(request.name)
            .let(ShoppingListResponse::from)
}