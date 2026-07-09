package io.github.antebantez.shopper.product

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProductRepository : JpaRepository<Product, UUID> {

    fun findByNameContainingIgnoreCase(name: String): List<Product>
}