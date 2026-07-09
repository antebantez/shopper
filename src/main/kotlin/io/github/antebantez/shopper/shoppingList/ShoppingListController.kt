package io.github.antebantez.shopper.shoppingList

import io.github.antebantez.shopper.shoppingList.api.CreateShoppingListRequest
import io.github.antebantez.shopper.shoppingList.api.ShoppingListResponse
import io.github.antebantez.shopper.shoppingList.api.UpdateShoppingListRequest
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/lists")
class ShoppingListController (private val shoppingListService: ShoppingListService){
    @GetMapping
    fun getAll(): List<ShoppingListResponse> =
        shoppingListService.getAll()
            .map(ShoppingListResponse::from)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): ResponseEntity<ShoppingListResponse> =
        shoppingListService.getById(id)
            ?.let { ResponseEntity.ok(ShoppingListResponse.from(it)) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun create(@Valid @RequestBody request: CreateShoppingListRequest) :
            ShoppingListResponse =
        shoppingListService.create(request.name)
            .let(ShoppingListResponse::from)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @Valid @RequestBody request: UpdateShoppingListRequest):
            ResponseEntity<ShoppingListResponse> =
        shoppingListService.update(id, request.name)
            ?.let { ResponseEntity.ok(ShoppingListResponse.from(it)) }
            ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Void> =
        if (shoppingListService.delete(id)){
            ResponseEntity.noContent().build()
        }
    else ResponseEntity.notFound().build()
}