package io.github.antebantez.shopper.product.api

import io.github.antebantez.shopper.product.Product
import java.time.Instant
import java.util.UUID

data class ProductResponse(
    val id: UUID,
    val name: String,
    val createdAt: Instant,
    val updatedAt: Instant
) {
    companion object {
        fun from(product: Product): ProductResponse =
            ProductResponse(
                id = product.id,
                name = product.name,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt
            )
    }
}