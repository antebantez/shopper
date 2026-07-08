package io.github.antebantez.shopper.shoppingList

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "shopping_lists")
class ShoppingList(

    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    val createdAt: Instant = Instant.now()


    )